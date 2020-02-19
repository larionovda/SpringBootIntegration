package com.larionov.epam.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    @Test
    public void getProductByArticleTrue() {
        Assertions.assertNotNull(productDAO.getProductByArticle(8L));
        Assertions.assertEquals(8L, productDAO
                .getProductByArticle(8L)
                .getArticle()
                .longValue());
    }




}
