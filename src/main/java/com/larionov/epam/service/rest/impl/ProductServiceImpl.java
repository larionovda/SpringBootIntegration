package com.larionov.epam.service.rest.impl;

import com.larionov.epam.dao.DataProduct;
import com.larionov.epam.item.Product;
import com.larionov.epam.service.rest.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    DataProduct dataProduct;

    @Async
    @Override
    public CompletableFuture<Product> getProductByArticle(Long article) {
        return CompletableFuture.completedFuture(dataProduct.getProductByArticle(article));
    }

    @Async
    @Override
    public CompletableFuture<List<Product>> getAllProduct() {
        return CompletableFuture.completedFuture(dataProduct.getAllProducts());
    }

    @Async
    @Override
    public void addNewProducts(Product product) {
        dataProduct.addProduct(product);
    }

    @Async
    @Override
    public void deleteProductById(Long article) {
        dataProduct.deleteProductById(article);
    }

    @Async
    @Override
    public void updateProductByArticle(Product product, Long article) {
        dataProduct.updateProductById(article, product.getIdBrand(), product.getIdType(), product.getIdCategory(), product.getPrice(), product.getIdSupplier());
    }
}
