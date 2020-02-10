package com.larionov.epam;

import com.larionov.epam.item.Product;
import com.larionov.epam.service.rest.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestRestController {

    @Autowired
    private ProductService productService;

    private Product product;
    private BigDecimal bigDecimal;

    @BeforeEach
    public void init() {
        bigDecimal = new BigDecimal(1090);
        product = new Product(2L, 2L, 2L, 1L, 2L, bigDecimal);
    }

    @Test
    public void testGetProductByArticle() throws ExecutionException, InterruptedException {
        Assertions.assertEquals(product.getArticle(), productService.getProductByArticle(2L).get().getArticle());
    }

    @Test
    public void testGetAllProducts() throws ExecutionException, InterruptedException {
        Assertions.assertEquals(6, productService.getAllProduct().get().size());
        Assertions.assertEquals(product.getArticle(), productService.getAllProduct().get().get(0).getArticle());
    }
}
