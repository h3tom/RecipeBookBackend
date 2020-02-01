package com.RecipeBookBackend.converter.dto;

import com.RecipeBookBackend.converter.BaseConverter;
import com.RecipeBookBackend.dto.UserDTO;
import com.RecipeBookBackend.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter implements BaseConverter<User, UserDTO> {

    @Override
    public UserDTO convert(User from) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(from.getId());
        userDTO.setUsername(from.getUsername());
        userDTO.setName(from.getName());
        userDTO.setEmail(from.getEmail());
        return userDTO;
    }
}
