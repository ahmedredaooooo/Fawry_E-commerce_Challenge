package com.customer;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        setName(name);
        setBalance(balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) throw new IllegalArgumentException("Name can't be Empty or Space");
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) throw new IllegalArgumentException("balance can't be negative");
        this.balance = balance;
    }
    public void withdrawMoney(double amount) {
        if (amount > balance) throw new IllegalArgumentException("You don't have enough money in your account");
        balance -= amount;
    }
}
