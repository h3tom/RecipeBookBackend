package com.RecipeBookBackend.controller;

import com.RecipeBookBackend.model.Recipe;
import com.RecipeBookBackend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/id")
    public Recipe getRecipe(Long id) {
        return recipeService.getRecipe(id);
    }
}
