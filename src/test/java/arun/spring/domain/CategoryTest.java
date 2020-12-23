package arun.spring.domain;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    Category category;

    @BeforeEach
    public void setUp(){
        category = new Category();
    }

    @Test
    void getId() {
        Long idValue = 2L;
        category.setId(idValue);
        assertEquals(2L,category.getId());
    }

    @Test
    void getDescription() {
        String catAmerican = "American";
        category.setDescription(catAmerican);
        assertEquals("American",category.getDescription());
    }

    @Test
    void getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(new Recipe());
        category.setRecipes(recipeSet);
        assertEquals(1,category.getRecipes().size());
    }
}