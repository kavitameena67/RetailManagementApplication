package com.userapp.model;

public class ProductDetails {

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductDetails() {

    }

    @Override
    public String toString() {
        return "{Product=" + product + "}";
    }
}
