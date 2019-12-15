package com.RecipeBookBackend.service;

import com.RecipeBookBackend.model.Recipe;
import com.RecipeBookBackend.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe getRecipe(Long id) {
        if (recipeRepository.existsById(id)) {
            return recipeRepository.getOne(id);
        } else {
            return null;
        }
    }

    public List<Recipe> getAllRecipes() {
        if (recipeRepository.count() > 0) {
            return recipeRepository.findAll();
        } else {
            return null;
        }
    }

    public boolean addOrUpdateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe).getId() != null;
    }

    public boolean deleteRecipe(Long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
