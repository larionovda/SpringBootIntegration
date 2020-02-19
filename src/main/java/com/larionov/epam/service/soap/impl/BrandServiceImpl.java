package com.larionov.epam.service.soap.impl;

import com.larionov.epam.dao.BrandDAO;
import com.larionov.epam.service.soap.BrandService;
import generated.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandDAO dataBrand;

    @Async
    @Override
    public Brand getBrandByID(Long id) {
        return dataBrand.getBrandByID(id);
    }
}