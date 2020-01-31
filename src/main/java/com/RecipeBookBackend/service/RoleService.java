package com.RecipeBookBackend.service;

import com.RecipeBookBackend.model.Role;
import com.RecipeBookBackend.model.RoleName;
import com.RecipeBookBackend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findByName(RoleName roleUser) {
        return roleRepository.findByName(roleUser);
    }
}
