package com.project.controller;

import com.project.model.User;
import com.project.service.MealService;
import com.project.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.project.util.ValidationUtil.assureIdConsistent;
import static com.project.util.ValidationUtil.checkNew;


@Controller
public abstract class AbstractUserController {

    @Autowired
    private final UserServiceImpl service;

    private Logger log = LoggerFactory.getLogger(MealService.class);

    protected AbstractUserController(UserServiceImpl service) {
        this.service = service;
    }


    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        checkNew(user);
        return service.create(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        assureIdConsistent(user, id);
        service.update(user);
    }

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return service.getByEmail(email);
    }
}