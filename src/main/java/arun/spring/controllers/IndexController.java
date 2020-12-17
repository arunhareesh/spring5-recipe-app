package arun.spring.controllers;

import arun.spring.domain.Category;
import arun.spring.domain.UnitOfMeasure;
import arun.spring.repositories.CategoryRepository;
import arun.spring.repositories.UnitOfMeasureRepository;
import arun.spring.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Inside indexController..");
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
