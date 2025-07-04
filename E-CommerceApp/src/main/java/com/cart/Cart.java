package com.cart;

import com.product.IExpirable;
import com.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<CartItem>();

    public void addProduct(Product product, int quantity) {
        if (product.getQuantity() < quantity) throw new IllegalArgumentException("Not enough product quantity available.");

        if (product instanceof IExpirable expirable && expirable.expired()) throw new IllegalStateException("Cannot add expired product to cart.");

        cartItems.add(new CartItem(product, quantity));
    }
    public List<CartItem> getItems() {
        return cartItems;
    }
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
    public double getSubtotal() {
        double sum = 0.0;
        for (CartItem item : cartItems) sum += item.getTotalPrice();
        return sum;
    }
}
