package com.RecipeBookBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter @Setter
public class IngredientDTO {

    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private Integer amount;

    @Override
    public String toString() {
        return "IngredientDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
