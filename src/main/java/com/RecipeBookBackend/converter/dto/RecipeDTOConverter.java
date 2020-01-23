package com.RecipeBookBackend.converter.dto;

import com.RecipeBookBackend.converter.BaseConverter;
import com.RecipeBookBackend.dto.IngredientDTO;
import com.RecipeBookBackend.dto.RecipeDTO;
import com.RecipeBookBackend.model.Ingredient;
import com.RecipeBookBackend.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecipeDTOConverter implements BaseConverter<Recipe, RecipeDTO> {

    private final BaseConverter<Ingredient, IngredientDTO> ingredientDTOConverter;

    @Autowired
    public RecipeDTOConverter(BaseConverter<Ingredient, IngredientDTO> ingredientDTOConverter) {
        this.ingredientDTOConverter = ingredientDTOConverter;
    }

    @Override
    public RecipeDTO convert(Recipe from) {
        return new RecipeDTO(
                from.getId(),
                from.getName(),
                from.getDescription(),
                from.getImagePath(),
                ingredientDTOConverter.convertAll(from.getIngredients())
        );
    }
}
