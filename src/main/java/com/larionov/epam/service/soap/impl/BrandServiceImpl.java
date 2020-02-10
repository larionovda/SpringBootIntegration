package com.larionov.epam.service.soap.impl;

import com.larionov.epam.dao.DataBrand;
import com.larionov.epam.service.soap.BrandService;
import generated.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    DataBrand dataBrand;

    @Async
    @Override
    public Brand getBrandByID(Long id) {
        return dataBrand.getBrandByID(id);
    }
}
