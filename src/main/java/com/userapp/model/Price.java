package com.userapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "productPrice")
public class Price {

    @Id
    private String productId;

    @Field(name = "value")
    private double value;

    @Field(name = "current_code")
    private String currentCode;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrentCode() {
        return currentCode;
    }

    public void setCurrentCode(String currentCode) {
        this.currentCode = currentCode;
    }

    public Price() {

    }

    public Price(String productId, double value, String currentCode) {
        this.productId = productId;
        this.value = value;
        this.currentCode = currentCode;
    }

    public String toString() {
        return String.format(
                "Price[id=%s, value='%s', currentCode='%s']",
                productId, value, currentCode);
    }
}
