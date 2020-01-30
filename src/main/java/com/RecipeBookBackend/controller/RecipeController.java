package com.RecipeBookBackend.controller;

import com.RecipeBookBackend.dto.RecipeDTO;
import com.RecipeBookBackend.dto.response.ApiResponse;
import com.RecipeBookBackend.dto.validated.AddRecipeValidation;
import com.RecipeBookBackend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import javax.validation.groups.Default;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    public RecipeDTO getRecipe(@PathVariable Long id) {
        return recipeService.getRecipe(id);
    }

    @GetMapping("/all")
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping(consumes = "application/json")
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<?> addRecipe(@Validated({AddRecipeValidation.class}) @RequestBody RecipeDTO recipeDTO) {
        if (recipeService.addOrUpdateRecipe(recipeDTO)) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/recipe/{id}")
                    .buildAndExpand(recipeDTO.getId()).toUri();
            return ResponseEntity.created(location).body(new ApiResponse(true, "Recipe added successfully"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Cannot add new recipe"));
        }
    }

    @PutMapping(consumes = "application/json")
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<?> updateRecipe(@Validated({Default.class}) @RequestBody RecipeDTO recipeDTO) {
        if (recipeService.addOrUpdateRecipe(recipeDTO)) {
            return ResponseEntity.ok().body(new ApiResponse(true, "Recipe updated successfully"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Cannot update recipe"));
        }
    }

    @DeleteMapping("/{id}")
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().body(new ApiResponse(true, "Recipe deleted successfully"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Cannot delete recipe"));
        }
    }

}
