package com.RecipeBookBackend.converter.dto;

import com.RecipeBookBackend.dto.IngredientDTO;
import com.RecipeBookBackend.dto.RecipeDTO;
import com.RecipeBookBackend.model.Ingredient;
import com.RecipeBookBackend.model.Recipe;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeConverter {

    public static Recipe getRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDTO.getId());
        recipe.setName(recipeDTO.getName());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setImagePath(recipeDTO.getImagePath());

        List<Ingredient> ingredients =
                IngredientConverter.getIngredients(recipeDTO.getIngredientDTOS());

        recipe.setIngredients(ingredients);
        return recipe;
    }

    public static List<RecipeDTO> getRecipeDTOS(List<Recipe> recipes) {
        return recipes.stream().map(RecipeConverter::getRecipeDTO).collect(Collectors.toList());
    }

    public static RecipeDTO getRecipeDTO(Recipe recipe) {
        List<IngredientDTO> ingredients =
                IngredientConverter.getIngredientDTOS(recipe.getIngredients());

        return new RecipeDTO(
                recipe.getId(),
                recipe.getName(),
                recipe.getDescription(),
                recipe.getImagePath(),
                ingredients
        );
    }
}
