package com.larionov.epam.dao;

import com.larionov.epam.item.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DataProduct {
    Product getProductByArticle(Long article);

    List<Product> getAllProducts();

    void addProduct(Product product);

    void deleteProductById(Long article);

    void updateProductById(Long article, Long idBrand, Long idType, Long idCategory, BigDecimal price, Long idSupplier);
}
