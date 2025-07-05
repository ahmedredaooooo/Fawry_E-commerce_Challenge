package com.helpers;

import com.cart.CartItem;
import com.product.IShippable;

import java.util.List;

public class ShippingService {
    public static void printShipmentNotice(List<CartItem> cartItems) {
        System.out.println("** Shipment Notice **");

        double totalPackageWeight = 0.0;
        for (CartItem item : cartItems) {
            boolean isShippable = item.getProduct() instanceof IShippable;

            if (isShippable) {
                IShippable shippable = (IShippable) item.getProduct();

                double singleProductWeight = shippable.getWeight();
                double itemTotalWeight = singleProductWeight * item.getQuantity();
                totalPackageWeight += itemTotalWeight;

                String forPrint = item.getQuantity() + "x "
                        + shippable.getName() + " "
                        + (int) (shippable.getWeight() * 1000) + "g";

                System.out.println(forPrint);
            }
        }
        System.out.println("Total package weight: " + String.format("%.1f", totalPackageWeight) + "kg\n");
    }
}