package com.larionov.epam.service.rest;

import com.larionov.epam.item.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product getProductByArticle(Long Article);

    List<Product> getAllProduct();

    void addNewProducts(Product product);

    void deleteProductById(Long Article);

    void updateProductByArticle(Product product, Long article);

}
