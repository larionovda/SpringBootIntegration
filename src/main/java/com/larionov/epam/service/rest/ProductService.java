package com.larionov.epam.service.rest;

import com.larionov.epam.item.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface ProductService {
    CompletableFuture<Product> getProductByArticle(Long Article);

    CompletableFuture<List<Product>> getAllProduct();

    void addNewProducts(Product product);

    void deleteProductById(Long Article);

    void updateProductByArticle(Product product, Long article);

}
