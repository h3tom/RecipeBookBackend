package com.RecipeBookBackend.controller;

import com.RecipeBookBackend.dto.RecipeDTO;
import com.RecipeBookBackend.dto.validated.AddRecipeValidation;
import com.RecipeBookBackend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
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
    public RecipeDTO getRecipe(@PathVariable Long id) {
        return recipeService.getRecipe(id);
    }

    @GetMapping("/all")
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping(consumes = "application/json")
    public HttpStatus addRecipe(@RequestBody @Validated({AddRecipeValidation.class}) RecipeDTO recipeDTO,
                                BindingResult result) {
        if (result.hasErrors()) {
            return HttpStatus.PRECONDITION_FAILED;
        }
        if (recipeService.addOrUpdateRecipe(recipeDTO)) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.PRECONDITION_FAILED;
        }
    }

    @PutMapping(consumes = "application/json")
    public HttpStatus updateRecipe(@RequestBody @Validated({Default.class}) RecipeDTO recipeDTO) {
        if (recipeService.addOrUpdateRecipe(recipeDTO)) {
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
