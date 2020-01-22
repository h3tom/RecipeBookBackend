package com.RecipeBookBackend.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class IngredientDTO {

    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private Integer amount;

}
