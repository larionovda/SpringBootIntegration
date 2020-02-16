package com.larionov.epam.mapper;

import com.larionov.epam.item.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUsername(resultSet.getString("user_name"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
