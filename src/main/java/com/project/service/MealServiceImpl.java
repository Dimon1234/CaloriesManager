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

import static com.project.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealServiceImpl implements MealService{

    private final MealRepository repository;

    private Logger LOG = LoggerFactory.getLogger(MealServiceImpl.class);

    @Autowired
    public MealServiceImpl(MealRepository repository) {
        this.repository = repository;
    }

    @CacheEvict(value = "meals", allEntries = true)
    public Meal create(Meal meal) {
        LOG.debug("meal " + meal + " saved successfully");
        return repository.save(meal);
    }

    @CacheEvict(value = "meals", allEntries = true)
    public void delete(long id) {
        repository.delete(id);
        LOG.debug("meal with id " + id + " deleted successfully");
    }

    public Meal get(long id) {
        LOG.debug("select from database one meal with id " + id);
        return repository.findOne(id);
    }
    public void update(Meal meal)
    {
        LOG.debug("meal "+meal+" updated successfully");
        checkNotFoundWithId(repository.save(meal),(int) meal.getId());
    }

    public List<Meal> getAll() {
        LOG.debug("select all meals from database");
        return repository.findAll();
    }

    @Cacheable("meals")
    public List<MealWithExceed> getAllWithExceed()
    {
        return MealsUtil.getWithExceeded(getAll(), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

}
