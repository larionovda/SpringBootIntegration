package com.larionov.epam.service.soap;

import generated.Brand;
import org.springframework.stereotype.Service;

@Service
public interface BrandService {
    Brand getBrandByID(Long id);
}
