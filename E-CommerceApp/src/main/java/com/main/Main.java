package com.main;

import com.cart.Cart;
import com.customer.Customer;
import com.helpers.CheckOutService;
import com.product.NeitherShippableNorExpirableProduct;
import com.product.Product;
import com.product.ShippableExpirableProduct;
import com.product.ShippableProduct;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // create customer
            Customer customer = new Customer("Ahmed", 3000);

            // create prods
            Product cheese = new ShippableExpirableProduct("Cheese", 100, 50, 0.2, LocalDate.now().plusDays(7));
            Product biscuits = new ShippableExpirableProduct("Biscuits", 150, 30, 0.7, LocalDate.now().plusDays(30));

            Product tv = new ShippableProduct("TV", 300, 2, 8.0);

            Product scratchCard = new NeitherShippableNorExpirableProduct("Scratch Card", 50, 15);

            // add to cart
            Cart cart = new Cart();
            cart.addProduct(cheese, 2);
            cart.addProduct(biscuits, 1);
            cart.addProduct(tv, 1);
            cart.addProduct(scratchCard, 1);

            //checkout
            CheckOutService.checkout(customer, cart);
        } catch (Exception exp) {
            System.out.println("Exception: " + exp.getMessage());
        }
    }
}
