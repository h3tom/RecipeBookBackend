package com.RecipeBookBackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ingredients")
@Getter @Setter
public class Ingredient extends AbstractEntity {

    @NotNull
    @Size(min = 1)
    private String name;

    @NotNull
    @Min(1)
    private Integer amount;

    public Ingredient() {
    }
}
