package com.RecipeBookBackend.dto;

import com.RecipeBookBackend.dto.validated.AddRecipeValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RecipeDTO {

    @NotNull
    private Long id;
    @NotBlank(groups = AddRecipeValidation.class)
    private String name;
    @NotBlank(groups = AddRecipeValidation.class)
    private String description;
    @NotBlank(groups = AddRecipeValidation.class)
    private String imagePath;
    @JsonProperty("ingredients")
    private List<IngredientDTO> ingredientDTOS = new ArrayList<>();

}
