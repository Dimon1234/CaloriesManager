package com.project.controller;

import com.project.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {


    private final MealService mealService;

    @Autowired
    public DefaultController(MealService mealService) {
        this.mealService = mealService;
    }


    @GetMapping("/")
    public ModelAndView home(ModelAndView model) {
        model.addObject("meals",  mealService.getAll());
        model.setViewName("list");
        return model;
    }

    @GetMapping("/delete")
    public ModelAndView delete(ModelAndView model, @RequestParam long id)
    {
        mealService.deleteMeal(id);
        model.addObject("meals", mealService.getAll());
        model.setViewName("list");
        return model;
    }




}
