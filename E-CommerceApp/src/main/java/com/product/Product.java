package com.product;

public abstract class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    public void setName(String name) {
        if (name.isBlank()) throw new IllegalArgumentException("product name can't be Empty or Space");
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if  (price <= 0) throw new IllegalArgumentException("price can't be Negative");
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("quantity can't be Negative");
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
}
