package com.larionov.epam.controller.rest;

import com.larionov.epam.item.Product;
import com.larionov.epam.service.rest.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }

    //localhost:9090/product/1
    @GetMapping("{article}")
    public Product getProductById(@PathVariable Long article) {
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
