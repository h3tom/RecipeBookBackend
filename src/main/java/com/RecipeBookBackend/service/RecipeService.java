package com.RecipeBookBackend.service;

import com.RecipeBookBackend.converter.BaseConverter;
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
    private final BaseConverter<Recipe, RecipeDTO> recipeDTOConverter;
    private final BaseConverter<RecipeDTO, Recipe> recipeConverter;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, BaseConverter<Recipe, RecipeDTO> recipeDTOConverter, BaseConverter<RecipeDTO, Recipe> recipeConverter) {
        this.recipeRepository = recipeRepository;
        this.recipeDTOConverter = recipeDTOConverter;
        this.recipeConverter = recipeConverter;
    }

    public RecipeDTO getRecipe(Long id) {
        if (recipeRepository.existsById(id)) {
            return recipeDTOConverter.convert(recipeRepository.getOne(id));
        } else {
            return null;
        }
    }

    public List<RecipeDTO> getAllRecipes() {
        if (recipeRepository.count() > 0) {
            List<Recipe> recipes = recipeRepository.findAll();
            return recipeDTOConverter.convertAll(recipes);
        } else {
            return null;
        }
    }

    public boolean addOrUpdateRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = recipeConverter.convert(recipeDTO);
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
