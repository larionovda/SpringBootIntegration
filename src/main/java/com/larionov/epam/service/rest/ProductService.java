package com.larionov.epam.service.rest;

import com.larionov.epam.item.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public interface ProductService {
    CompletableFuture<List<Product>> getProductsByPrice(BigDecimal price) throws ExecutionException, InterruptedException;

    CompletableFuture<List<Product>> getAllProduct() throws ExecutionException, InterruptedException;

    CompletableFuture<Product> getProductByArticle(Long Article);

    void addNewProducts(Product product);

    void deleteProductById(Long Article);

    void updateProductByArticle(Product product);

    Page<Product> findPaginated(Pageable pageable);

}
