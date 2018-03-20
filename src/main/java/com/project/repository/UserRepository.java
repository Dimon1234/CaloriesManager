package com.project.repository;


import com.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "delete from User u where u.id=Id")
    User delete(@Param("Id") int id);

    @Query(value = "select u from User u where u.email = Email")
    User getByEmail(@Param("Email") String email);
}
