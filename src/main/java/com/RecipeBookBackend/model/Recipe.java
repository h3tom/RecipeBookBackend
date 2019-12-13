package com.RecipeBookBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @JoinColumn(name="recipe_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private @Getter @Setter List<Ingredient> ingredients = new ArrayList<>();

    public Recipe() {
    }
}
