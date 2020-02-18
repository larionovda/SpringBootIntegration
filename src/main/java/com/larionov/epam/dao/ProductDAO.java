package com.larionov.epam.dao;

import com.larionov.epam.item.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductDAO {
    List<Product> getProductsByPrice(BigDecimal price);

    List<Product> getAllProducts();

    Product getProductByArticle(Long article);

    void addProduct(Product product);

    void deleteProductById(Long article);

    void updateProductById(Long article, Long idBrand, Long idType, Long idCategory, BigDecimal price, Long idSupplier);
}
