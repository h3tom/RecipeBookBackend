package com.RecipeBookBackend.converter.entity;

import com.RecipeBookBackend.converter.BaseConverter;
import com.RecipeBookBackend.dto.IngredientDTO;
import com.RecipeBookBackend.dto.RecipeDTO;
import com.RecipeBookBackend.model.Ingredient;
import com.RecipeBookBackend.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecipeConverter implements BaseConverter<RecipeDTO, Recipe> {

    private final BaseConverter<IngredientDTO, Ingredient> ingredientConverter;

    @Autowired
    public RecipeConverter(BaseConverter<IngredientDTO, Ingredient> ingredientConverter) {
        this.ingredientConverter = ingredientConverter;
    }

    @Override
    public Recipe convert(RecipeDTO from) {
        Recipe recipe = new Recipe();
        recipe.setId(from.getId());
        recipe.setName(from.getName());
        recipe.setDescription(from.getDescription());
        recipe.setImagePath(from.getImagePath());
        recipe.setIngredients(ingredientConverter.convertAll(from.getIngredientDTOS()));
        return recipe;
    }
}
