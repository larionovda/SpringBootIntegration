package com.larionov.epam.mapper;

import generated.Brand;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BrandMapper implements RowMapper<Brand> {
    @Override
    public Brand mapRow(ResultSet resultSet, int i) throws SQLException {
        Brand brand = new Brand();
        brand.setId((long) resultSet.getInt("id"));
        brand.setName(resultSet.getString("name"));
        return brand;
    }
}
