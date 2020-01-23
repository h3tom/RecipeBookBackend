package com.RecipeBookBackend.converter.dto;

import com.RecipeBookBackend.converter.BaseConverter;
import com.RecipeBookBackend.dto.IngredientDTO;
import com.RecipeBookBackend.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientDTOConverter implements BaseConverter<Ingredient, IngredientDTO> {

    @Override
    public IngredientDTO convert(Ingredient from) {
        return new IngredientDTO(
                from.getId(),
                from.getName(),
                from.getAmount()
        );
    }

}
