package com.product;

import java.time.LocalDate;
import java.util.Date;

public class ShippableExpirableProduct extends ExpirableProduct implements IExpirable, IShippable {
    private double weight;
    public ShippableExpirableProduct(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity, expiryDate);
        setWeight(weight);
    }

    public void setWeight(double weight) {
        if (weight <= 0) throw new IllegalArgumentException("weight can't be Negative");
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}