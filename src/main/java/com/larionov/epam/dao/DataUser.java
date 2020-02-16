package com.larionov.epam.dao;

import com.larionov.epam.item.User;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataUser {
    Optional<User> findByUserName(@NonNull String username);
    void addUser(User user);
}
