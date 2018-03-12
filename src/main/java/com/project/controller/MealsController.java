package com.project.controller;

import com.project.model.Meal;
import com.project.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MealsController {


    private final MealService mealService;

    @Autowired
    public MealsController(MealService mealService) {
        this.mealService = mealService;
    }


    @GetMapping("/")
    public ModelAndView home(ModelAndView model) {
        model.addObject("meals", mealService.getAllWithExceed());
        model.addObject("newMeal", new Meal());
        model.setViewName("meals");
        return model;
    }

    @GetMapping("/delete")
    public String delete(ModelAndView model, @RequestParam long id) {
        mealService.deleteMeal(id);
        model.addObject("meals", mealService.getAllWithExceed());
        model.setViewName("meals");
        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveMeal(@ModelAttribute("newMeal") Meal meal) {
        mealService.saveMeal(meal);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public ModelAndView editMeal(ModelAndView model, @RequestParam long id) {
        model.addObject("newMeal", mealService.findOne(id));
        model.addObject("meals", mealService.getAllWithExceed());
        model.setViewName("meals");
        return model;
    }


}
