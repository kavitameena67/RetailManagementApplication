package com.userapp.model;

public class ProductDescription {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductDescription() {

    }

    @Override
    public String toString() {
        return "{title=" + title + "}";
    }
}
