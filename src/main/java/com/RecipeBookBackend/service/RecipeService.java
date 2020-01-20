package com.RecipeBookBackend.service;

import com.RecipeBookBackend.converter.dto.RecipeConverter;
import com.RecipeBookBackend.dto.RecipeDTO;
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

    public RecipeDTO getRecipe(Long id) {
        if (recipeRepository.existsById(id)) {
            return RecipeConverter.getRecipeDTO(recipeRepository.getOne(id));
        } else {
            return null;
        }
    }

    public List<RecipeDTO> getAllRecipes() {
        if (recipeRepository.count() > 0) {
            List<Recipe> recipes = recipeRepository.findAll();
            return RecipeConverter.getRecipeDTOS(recipes);
        } else {
            return null;
        }
    }

    public boolean addOrUpdateRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = RecipeConverter.getRecipe(recipeDTO);
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
