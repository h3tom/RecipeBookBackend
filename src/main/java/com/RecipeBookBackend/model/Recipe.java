package com.RecipeBookBackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe extends AbstractEntity {

    @Size(min = 1)
    @NotNull
    private @Getter @Setter String name;

    @Size(min = 1)
    @NotNull
    private @Getter @Setter String description;

    @NotNull
    private @Getter @Setter String imagePath;

    @OneToMany
    private @Getter @Setter List<Ingredient> ingredients = new ArrayList<>();

    public Recipe() {
    }
}
