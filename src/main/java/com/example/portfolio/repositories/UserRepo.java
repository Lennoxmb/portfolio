package com.example.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.portfolio.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface UserRepo extends JpaRepository<User, Long> {
        User findUserById(long id);
        User findUserByUsername(String username);
}
