package com.userapp.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class ProductPriceDetails {

    @Field(name = "id")
    String id;

    @Field(name = "name")
    String name;

    @Field(name = "current_price")
    Price currentPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Price currentPrice) {
        this.currentPrice = currentPrice;
    }

    public ProductPriceDetails() {

    }

    public ProductPriceDetails(String id, String name, Price currentPrice) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
    }
}
