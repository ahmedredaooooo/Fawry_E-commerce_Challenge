package com.cart;

import com.product.Product;

public class CartItem {
    private Product product;
    private int quantity;
    public CartItem(Product product, int quantity) {
        setProduct(product);
        setQuantity(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if  (product == null) throw new IllegalArgumentException("product can't be null");
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("quantity can't be 0 and can't be negative");
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public String getProductName() {
        return product.getName();
    }
}
