package com.larionov.epam.item;

import java.math.BigDecimal;

public class Product {
    private Long article;
    private Long idBrand;
    private Long idType;
    private Long idCategory;
    private Long idSupplier;
    private BigDecimal price;

    public Product(Long article, Long idBrand, Long idType, Long idCategory, Long idSupplier, BigDecimal price) {
        this.article = article;
        this.idBrand = idBrand;
        this.idType = idType;
        this.idCategory = idCategory;
        this.idSupplier = idSupplier;
        this.price = price;
    }

    public Product() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getArticle() {
        return article;
    }

    public void setArticle(Long article) {
        this.article = article;
    }

    public Long getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Long idBrand) {
        this.idBrand = idBrand;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Long getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Long idSupplier) {
        this.idSupplier = idSupplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "article=" + article +
                ", idBrand=" + idBrand +
                ", idType=" + idType +
                ", idCategory=" + idCategory +
                ", idSupplier=" + idSupplier +
                '}';
    }
}
