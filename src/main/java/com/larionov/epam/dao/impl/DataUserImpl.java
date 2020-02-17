package com.larionov.epam.dao.impl;

import com.larionov.epam.dao.DataUser;
import com.larionov.epam.item.User;
import com.larionov.epam.mapper.UserMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DataUserImpl implements DataUser {

    private final String SQL_QUERY_GET_USER_NAME = "SELECT user_name, password\n" +
            " FROM public.\"Order\" where user_name = ?";
    private final String SQL_INSERT_INTO = "INSERT INTO public.\"Order\"(\n" +
            "\tuser_name, password)\n" +
            "\tVALUES (?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Optional<User> findByUserName(@NonNull String username) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_QUERY_GET_USER_NAME, new Object[]{username}, userMapper));
    }

    @Override
    public void addUser(String username, String password) {
        jdbcTemplate.update(SQL_INSERT_INTO, username, password);
    }
}
