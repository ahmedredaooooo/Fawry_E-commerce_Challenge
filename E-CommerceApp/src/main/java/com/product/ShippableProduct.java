package com.product;

public class ShippableProduct extends Product implements IShippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
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
}
