package com.larionov.epam.service;

import com.larionov.epam.dao.ProductDAO;
import com.larionov.epam.item.Product;
import com.larionov.epam.service.rest.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private ProductDAO productDAO;
    @InjectMocks
    private ProductService productService;

    private List<Product> products;


    @Autowired
    public ProductServiceTest(ProductService productService, Product product) {
        this.productService = productService;
    }

    @BeforeEach
    public void init() {
        Product product = Product
                .builder()
                .article(1L)
                .idBrand(1L)
                .idCategory(2L)
                .idSupplier(1L)
                .idType(2L)
                .price(new BigDecimal("500.00"))
                .build();
        products = new ArrayList<>(Collections.singletonList(product));
        Mockito.when(productDAO.getProductByArticle(1L)).thenReturn(product);
        Mockito.when(productDAO.getProductsByPrice(new BigDecimal(500))).thenReturn(products);
        Mockito.when(productDAO.getAllProducts()).thenReturn(products);
    }

    @Test
    public void checkProductByArticle() throws ExecutionException, InterruptedException {
        Assertions.assertEquals(1L, productService
                .getProductByArticle(1L)
                .get()
                .getArticle()
                .longValue());
    }

    @Test
    public void checkProductsByPrice() throws ExecutionException, InterruptedException {
        Assertions.assertIterableEquals(products, productService.getProductsByPrice(new BigDecimal(500)).get());
    }

    @Test
    public void checkAllProducts() throws ExecutionException, InterruptedException {
        Assertions.assertIterableEquals(products, productService.getAllProduct().get());
    }


}
