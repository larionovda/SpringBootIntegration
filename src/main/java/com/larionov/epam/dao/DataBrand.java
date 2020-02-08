package com.larionov.epam.dao;

import generated.Brand;
import org.springframework.stereotype.Repository;

@Repository
public interface DataBrand {
    Brand getBrandByID(Long id);
}
