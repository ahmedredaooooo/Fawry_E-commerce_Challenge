package com.product;

import java.time.LocalDate;

public class ExpirableProduct extends Product implements IExpirable {
    private LocalDate expiryDate;
    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        setExpiryDate(expiryDate);
    }

    public void setExpiryDate(LocalDate expiryDate) {
        if (expiryDate.isBefore(LocalDate.now())) throw new IllegalArgumentException("already expired");
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean expired() {
        return LocalDate.now().isAfter(getExpiryDate());
    }
}
