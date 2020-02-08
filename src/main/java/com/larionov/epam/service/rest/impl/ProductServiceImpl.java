package com.larionov.epam.service.rest.impl;

import com.larionov.epam.dao.DataProduct;
import com.larionov.epam.item.Product;
import com.larionov.epam.service.rest.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    DataProduct dataProduct;

    @Override
    public Product getProductByArticle(Long article) {
        return dataProduct.getProductByArticle(article);
    }

    @Override
    public List<Product> getAllProduct() {
        return dataProduct.getAllProducts();
    }

    @Override
    public void addNewProducts(Product product) {
        dataProduct.addProduct(product);
    }

    @Override
    public void deleteProductById(Long article) {
        dataProduct.deleteProductById(article);
    }

    @Override
    public void updateProductByArticle(Product product, Long article) {
        dataProduct.updateProductById(article, product.getIdBrand(), product.getIdType(), product.getIdCategory(), product.getPrice(), product.getIdSupplier());
    }
}
