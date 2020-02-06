package com.larionov.epam.controller.rest;

import com.larionov.epam.dao.DataProduct;
import com.larionov.epam.item.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class MessageController {

    @Autowired
    DataProduct dataProduct;

    @GetMapping
    public List<Product> fetAllProducts(){
        return dataProduct.getAllProducts();
    }

    //localhost:9090/product/1
    @GetMapping("{id}")
    public Product getOne(@PathVariable long id) {
        return dataProduct.getProductByArticle(id);
    }

    @PostMapping
    public void addNewProduct(@RequestBody Product newProduct) {
        dataProduct.addProduct(newProduct);
    }

    @PutMapping("{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable long id) {
        dataProduct.updateProductById(id, product.getIdBrand(), product.getIdType(), product.getIdCategory(), product.getPrice(), product.getIdSupplier());
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable long id) {
        dataProduct.deleteProductById(id);
    }

}
