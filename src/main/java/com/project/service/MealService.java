package com.project.service;

import com.project.model.Meal;
import com.project.model.MealWithExceed;
import com.project.util.exception.NotFoundException;

import java.util.List;

public interface MealService {

    Meal create(Meal meal);

    void delete(long id) throws NotFoundException;

    Meal get(long id) throws NotFoundException;

    void update(Meal meal);

    List<Meal> getAll();

    List<MealWithExceed> getAllWithExceed();
}
