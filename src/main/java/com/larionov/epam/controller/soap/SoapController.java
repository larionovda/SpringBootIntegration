package com.larionov.epam.controller.soap;

import com.larionov.epam.service.soap.BrandService;
import generated.GetBrandRequest;
import generated.GetBrandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapController {
    private static final String NAMESPACE_URI = "http://larionov.com/epam-spring-boot-soap";

    @Autowired
    BrandService brandService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBrandRequest")
    @ResponsePayload
    GetBrandResponse getBrandRequest(@RequestPayload GetBrandRequest request) {
        GetBrandResponse response = new GetBrandResponse();
        response.setBrand(brandService.getBrandByID(request.getId()));
        return response;
    }


}
