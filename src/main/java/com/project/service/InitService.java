package com.project.service;

import com.project.model.Meal;
import com.project.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Service
public class InitService {

    private final MealRepository mealRepository;

    @Autowired
    public InitService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @PostConstruct
    public void initDB()
    {
        List<Meal> meals = Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        mealRepository.save(meals);
    }
}
