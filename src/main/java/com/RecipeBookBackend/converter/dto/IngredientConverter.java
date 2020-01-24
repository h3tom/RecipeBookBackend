package com.RecipeBookBackend.converter.dto;

import com.RecipeBookBackend.dto.IngredientDTO;
import com.RecipeBookBackend.model.Ingredient;

import java.util.List;
import java.util.stream.Collectors;

@Deprecated
public class IngredientConverter {

    public static List<Ingredient> getIngredients(List<IngredientDTO> ingredientDTOS) {
        return ingredientDTOS == null ?
                null :
                ingredientDTOS.stream().map(ingredientDTO -> {
                    Ingredient ingredient = new Ingredient();
                    ingredient.setId(ingredientDTO.getId());
                    ingredient.setName(ingredientDTO.getName());
                    ingredient.setAmount(ingredientDTO.getAmount());
                    return ingredient;
                }).collect(Collectors.toList());
    }

    public static List<IngredientDTO> getIngredientDTOS(List<Ingredient> ingredients) {
        return ingredients.stream().map(IngredientConverter::getIngredientDTO).collect(Collectors.toList());
    }

    public static IngredientDTO getIngredientDTO(Ingredient ingredient) {
        return new IngredientDTO(ingredient.getId(), ingredient.getName(), ingredient.getAmount());
    }
}
