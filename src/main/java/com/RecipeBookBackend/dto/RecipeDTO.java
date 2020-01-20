package com.RecipeBookBackend.dto;

import com.RecipeBookBackend.dto.validated.AddRecipeValidation;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter @Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", ingredientDTOS=" + ingredientDTOS +
                '}';
    }
}