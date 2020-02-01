package com.RecipeBookBackend.service;

import com.RecipeBookBackend.converter.BaseConverter;
import com.RecipeBookBackend.dto.UserDTO;
import com.RecipeBookBackend.model.User;
import com.RecipeBookBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BaseConverter<User,UserDTO> userDTOConverter;

    @Autowired
    public UserService(UserRepository userRepository, BaseConverter<User, UserDTO> userDTOConverter) {
        this.userRepository = userRepository;
        this.userDTOConverter = userDTOConverter;
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean save(User user) {
        return userRepository.save(user).getId() != null;
    }

    public UserDTO getUserDTO(String usernameOrEmail) {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );
        return userDTOConverter.convert(user);
    }
}
