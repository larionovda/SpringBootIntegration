package com.larionov.epam.dao.impl;

import com.larionov.epam.dao.BrandDAO;
import com.larionov.epam.mapper.BrandMapper;
import generated.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BrandDAOImpl implements BrandDAO {
    private static final String SQL_GET_ONE_BRAND = "SELECT id, name\n" +
            "\tFROM public.\"Brand\" where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public Brand getBrandByID(Long id) {
        return jdbcTemplate.queryForObject(SQL_GET_ONE_BRAND, new Object[]{id}, brandMapper);
    }
}
