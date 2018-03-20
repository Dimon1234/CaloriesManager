package com.project.controller;

import com.project.model.Meal;
import com.project.service.MealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MealsController {


    private final MealServiceImpl mealServiceImpl;

    @Autowired
    public MealsController(MealServiceImpl mealServiceImpl) {
        this.mealServiceImpl = mealServiceImpl;
    }


    @GetMapping("/")
    public ModelAndView home(ModelAndView model) {
        model.addObject("meals", mealServiceImpl.getAllWithExceed());
        model.addObject("newMeal", new Meal());
        model.setViewName("meals");
        return model;
    }

    @GetMapping("/delete")
    public String delete(ModelAndView model, @RequestParam long id) {
        mealServiceImpl.delete(id);
        model.addObject("meals", mealServiceImpl.getAllWithExceed());
        model.setViewName("meals");
        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveMeal(@ModelAttribute("newMeal") Meal meal) {
        mealServiceImpl.create(meal);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public ModelAndView editMeal(ModelAndView model, @RequestParam long id) {
        model.addObject("newMeal", mealServiceImpl.get(id));
        model.addObject("meals", mealServiceImpl.getAllWithExceed());
        model.setViewName("meals");
        return model;
    }


}
