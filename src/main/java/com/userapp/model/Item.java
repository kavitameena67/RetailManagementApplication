package com.userapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    @JsonProperty("product_description")
    private ProductDescription productDescription;

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    public Item() {

    }

    @Override
    public String toString() {
        return "{productDescription=" + productDescription + "}";
    }
}
