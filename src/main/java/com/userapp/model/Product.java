package com.userapp.model;

public class Product {

    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Product() {

    }

    @Override
    public String toString() {
        return "{item=" + item + "}";
    }
}
