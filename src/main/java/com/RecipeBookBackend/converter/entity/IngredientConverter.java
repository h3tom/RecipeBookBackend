package com.RecipeBookBackend.converter.entity;

import com.RecipeBookBackend.converter.BaseConverter;
import com.RecipeBookBackend.dto.IngredientDTO;
import com.RecipeBookBackend.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientConverter implements BaseConverter<IngredientDTO, Ingredient> {

    @Override
    public Ingredient convert(IngredientDTO from) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(from.getId());
        ingredient.setName(from.getName());
        ingredient.setAmount(from.getAmount());
        return ingredient;
    }
}
