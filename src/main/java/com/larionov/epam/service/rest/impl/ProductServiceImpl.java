package com.larionov.epam.service.rest.impl;

import com.larionov.epam.dao.DataProduct;
import com.larionov.epam.item.Product;
import com.larionov.epam.service.rest.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    DataProduct dataProduct;

    @Async
    @Override
    public CompletableFuture<List<Product>> getProductsByPrice(BigDecimal price) throws ExecutionException, InterruptedException {
        return CompletableFuture.completedFuture(dataProduct.getProductsByPrice(price));
    }

    @Async
    @Override
    public CompletableFuture<List<Product>> getAllProduct() throws ExecutionException, InterruptedException {
        return CompletableFuture.completedFuture(dataProduct.getAllProducts());
    }

    @Async
    @Override
    public CompletableFuture<Product> getProductByArticle(Long article) {
        return CompletableFuture.completedFuture(dataProduct.getProductByArticle(article));
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
    public void updateProductByArticle(Product product) {
        dataProduct.updateProductById(product.getArticle(), product.getIdBrand(), product.getIdType(), product.getIdCategory(), product.getPrice(), product.getIdSupplier());
    }
}
