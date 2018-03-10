package com.project.service;


import com.project.model.Meal;
import com.project.model.MealWithExceed;
import com.project.repository.MealRepository;
import com.project.util.MealsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository repository;

    private Logger LOG = LoggerFactory.getLogger(MealService.class);

    public void saveMeal(Meal meal) {
        repository.save(meal);
        LOG.debug("meal " + meal + " saved successfully");
    }

    public void deleteMeal(long id) {
        repository.delete(id);
        LOG.debug("meal with id " + id + " deleted successfully");
    }

    public Meal findOne(long id) {
        return repository.findOne(id);
    }

    public List<Meal> getAll() {
        return repository.findAll();
    }

    public List<MealWithExceed> getListMealWithExceed(int caloriesPerDay) {
        return MealsUtil.getFilteredWithExceeded(repository.findAll(), LocalTime.MIN, LocalTime.MAX, caloriesPerDay);
    }
}
