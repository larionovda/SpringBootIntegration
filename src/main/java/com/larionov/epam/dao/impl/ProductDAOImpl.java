package com.larionov.epam.dao.impl;

import com.larionov.epam.dao.ProductDAO;
import com.larionov.epam.item.Product;
import com.larionov.epam.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private final String SQL_QUERY_GET_PRODUCT_PRICE = "SELECT *\n" +
            "\tFROM public.\"Products\" where price = ?";
    private final String SQL_QUERY_GET_ALL = "SELECT * FROM public.\"Products\"";
    private final String SQL_INSERT_INTO = "INSERT INTO public.\"Products\"(\n" +
            "\tid_brand, id_type, id_category, price, id_supplier)\n" +
            "\tVALUES (?, ?, ?, ?, ?)";
    private final String SQL_DELETE_BY_ID = "DELETE FROM public.\"Products\"\n" +
            "\tWHERE article = ?";
    private final String SQL_UPDATE_BY_ID = "UPDATE public.\"Products\"\n" +
            "\tSET id_brand = ?, id_type = ?, id_category = ?, price = ?, id_supplier = ?\n" +
            "\tWHERE article = ?;";
    private final String SQL_QUERY_GET_PRODUCT_ID = "SELECT * FROM public.\"Products\" where article = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductsByPrice(BigDecimal price) {
        return jdbcTemplate.query(SQL_QUERY_GET_PRODUCT_PRICE, new Object[]{price}, productMapper);
    }

    @Override
    public List<Product> getAllProducts() {
        return jdbcTemplate.query(SQL_QUERY_GET_ALL, productMapper);
    }

    @Override
    //@Cacheable("product")
    public Product getProductByArticle(Long article) {
        return jdbcTemplate.queryForObject(SQL_QUERY_GET_PRODUCT_ID, new Object[]{article}, productMapper);
    }

    @Override
    public void addProduct(Product product) {
        jdbcTemplate.update(SQL_INSERT_INTO, product.getIdBrand(), product.getIdType(), product.getIdCategory(), product.getPrice(), product.getIdSupplier());
    }

    @Override
    public void deleteProductById(Long article) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, article);
    }

    @Override
    public void updateProductById(Long article, Long idBrand, Long idType, Long idCategory, BigDecimal price, Long idSupplier) {
        jdbcTemplate.update(SQL_UPDATE_BY_ID, idBrand, idType, idCategory, price, idSupplier, article);
    }
}
