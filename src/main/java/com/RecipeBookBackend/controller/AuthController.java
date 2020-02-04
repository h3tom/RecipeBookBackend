package com.RecipeBookBackend.controller;

import com.RecipeBookBackend.dto.UserDTO;
import com.RecipeBookBackend.dto.auth.LoginFormDTO;
import com.RecipeBookBackend.dto.auth.SignUpFormDTO;
import com.RecipeBookBackend.dto.response.ApiResponse;
import com.RecipeBookBackend.dto.response.JwtAuthenticationResponse;
import com.RecipeBookBackend.model.Role;
import com.RecipeBookBackend.model.RoleName;
import com.RecipeBookBackend.model.User;
import com.RecipeBookBackend.security.JwtTokenProvider;
import com.RecipeBookBackend.service.RoleService;
import com.RecipeBookBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    @Autowired
    public AuthController(PasswordEncoder passwordEncoder, RoleService roleService, UserService userService, AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider) {
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginFormDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );
        UserDTO userDTO = userService.getUserDTO(loginRequest.getUsernameOrEmail());
        String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token, userDTO, jwtExpirationInMs));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpFormDTO signUpRequest) throws Exception {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Username is already taken"));
        }
        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Email Address already in use"));
        }

        // create User
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        Role userRole = roleService.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new Exception("User Role not set"));
        user.setRoles(Collections.singleton(userRole));

        // save User
        if (userService.save(user)) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/user/{username}")
                    .buildAndExpand(user.getUsername()).toUri();
            return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Cannot register new User"));
        }
    }

}
