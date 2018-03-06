package com.project.controller;

import com.project.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

    private final MealRepository mealRepository;

    @Autowired
    public DefaultController(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @GetMapping("/")
    public ModelAndView home(ModelAndView model) {
        model.addObject("meals",  mealRepository.findAll());
        model.setViewName("list");
        return model;
    }


}
