package com.project.service;


import com.project.model.Meal;
import com.project.model.MealWithExceed;
import com.project.repository.MealRepository;
import com.project.util.MealsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository repository;

    private Logger LOG = LoggerFactory.getLogger(MealService.class);

    @CacheEvict(value = "meals", allEntries = true)
    public void saveMeal(Meal meal) {
        repository.save(meal);
        LOG.debug("meal " + meal + " saved successfully");
    }

    @CacheEvict(value = "meals", allEntries = true)
    public void deleteMeal(long id) {
        repository.delete(id);
        LOG.debug("meal with id " + id + " deleted successfully");
    }

    public Meal findOne(long id) {
        LOG.debug("select from database one meal with id " + id);
        return repository.findOne(id);
    }


    private List<Meal> getAll() {
        LOG.debug("select all meals from database");
        return repository.findAll();
    }

    @Cacheable("meals")
    public List<MealWithExceed> getAllWithExceed()
    {
        return MealsUtil.getWithExceeded(getAll(), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

}
