---

# Fawry E-Commerce System

A simple Java-based e-commerce simulation that supports adding products to a cart, checking out, and calculating shipping; all while handling real-world edge cases like expired items and stock limits.

---

## Features

* Add products (e.g., Cheese, TV, Scratch Cards) with name, price, quantity
* Supports special product types:

  * **Expirable** (e.g., food items)
  * **Shippable** (e.g., electronics)
* Checkout includes:

  * Subtotal + shipping fees (if applicable)
  * Balance check
  * Stock validation
  * Expiry check
* Console-based **shipment summary** and **checkout receipt**

---

## ⚠️Error Handling

The system checks and throws clear exceptions if:

* The cart is **empty**
* The customer's **balance is insufficient**
* A product is **out of stock**
* A product is **already expired**
* Invalid input (e.g., null or negative quantities)

All of these are caught and displayed cleanly in the main method to avoid program crashes.

---

## 🧪 Sample Flow
<img src="sample test input.png" alt="Sample Flow" width="800"/>
Console Output:
<img src="sample test output.png" alt="Sample Console Output" width="500"/>
---

## ✅ Tech Highlights

* **Java**
* **OOP**: Abstract classes, interfaces (`IShippable`, `IExpirable`)
* Defensive programming with **validation** and **exception handling**
* Organized packages: `product`, `cart`, `helpers`, `customer`, `main`

---
