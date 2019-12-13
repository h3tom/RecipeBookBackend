package com.RecipeBookBackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ingredients")
public class Ingredient extends AbstractEntity{

    @NotNull
    @Size(min = 1)
    private @Getter @Setter String name;

    @NotNull
    @Size(min = 1)
    private @Getter @Setter Integer amount;

    public Ingredient() {
    }
}
