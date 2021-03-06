package com.project.service;


import com.project.model.User;
import com.project.repository.UserRepository;
import com.project.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.util.ValidationUtil.checkNotFound;
import static com.project.util.ValidationUtil.checkNotFoundWithId;

//TODO Add caching
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.findOne(id), id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(User user) {
        checkNotFoundWithId(repository.save(user), user.getId());
    }
}
