package com.larionov.epam.controller.rest;

import com.larionov.epam.item.Product;
import com.larionov.epam.service.rest.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("product")
public class RestController {

    @Autowired
    ProductService productService;

    @GetMapping
    public CompletableFuture<List<Product>> getAllProducts() {
        return productService.getAllProduct();
    }

    @GetMapping("{article}")
    public CompletableFuture<Product> getProductByIdAs(@PathVariable Long article) {
        return productService.getProductByArticle(article);
    }

    @PostMapping
    public void addNewProduct(@RequestBody Product newProduct) {
        productService.addNewProducts(newProduct);
    }

    @PutMapping("{article}")
    public void updateProduct(@RequestBody Product product, @PathVariable Long article) {
        productService.updateProductByArticle(product, article);
    }

    @DeleteMapping("{article}")
    public void deleteProduct(@PathVariable Long article) {
        productService.deleteProductById(article);
    }

}
