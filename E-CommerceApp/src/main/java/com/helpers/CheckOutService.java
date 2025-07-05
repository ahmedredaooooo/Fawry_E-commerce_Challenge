package com.helpers;

import com.cart.Cart;
import com.cart.CartItem;
import com.customer.Customer;
import com.product.IExpirable;
import com.product.IShippable;
import com.product.Product;

import java.util.List;

public class CheckOutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty())
            throw new IllegalStateException("Cart is empty");

        List<CartItem> cartItems = cart.getItems();

        for (CartItem item : cartItems) {
            Product product = item.getProduct();
            int requestedQuantity = item.getQuantity();

            if (product instanceof IExpirable) {
                IExpirable expirable = (IExpirable) product;
                if (expirable.expired())
                    throw new IllegalStateException("product " + product.getName() + " is expired.");

            }

            if (product.getQuantity() < requestedQuantity)
                throw new IllegalStateException("Product " + product.getName() + " is out of stock.");
        }

        double subtotal = cart.getSubtotal();

        boolean hasShippable = false;
        for (CartItem item : cartItems)
            if (item.getProduct() instanceof IShippable) {
                hasShippable = true;
                break;
            }
        int shippingFees;
        if (hasShippable)
            shippingFees = 30;
        else shippingFees = 0;

        double totalPrice = subtotal + shippingFees;

        if (customer.getBalance() < totalPrice) throw new IllegalStateException("Balance is insufficient");

        customer.withdrawMoney(totalPrice);

        if (hasShippable) ShippingService.printShipmentNotice(cartItems);


        System.out.println("** Checkout receipt **");
        for (CartItem item : cartItems) {
            double itemTotalPrice = item.getTotalPrice();
            System.out.println(item.getQuantity() + "x " + item.getProductName() + " " + itemTotalPrice);
        }

        System.out.println("----------------------------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingFees);
        System.out.println("Amount " + totalPrice);
        System.out.println("Customer balance: " + customer.getBalance());

    }

}