package com.RecipeBookBackend.controller;

import com.RecipeBookBackend.model.Recipe;
import com.RecipeBookBackend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Recipe getRecipe(@PathVariable Long id) {
        return recipeService.getRecipe(id);
    }

    @GetMapping("/all")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping(consumes = "application/json")
    public HttpStatus addRecipe(@RequestBody Recipe recipe) {
        if (recipeService.addOrUpdateRecipe(recipe)) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.PRECONDITION_FAILED;
        }
    }

    @PutMapping(consumes = "application/json")
    public HttpStatus updateRecipe(@RequestBody Recipe recipe) {
        if (recipeService.addOrUpdateRecipe(recipe)) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.PRECONDITION_FAILED;
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteRecipe(@PathVariable Long id) {
        if (recipeService.deleteRecipe(id)) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.PRECONDITION_FAILED;
        }
    }

}
