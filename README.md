# 🍴 Food Delivery System – Java Project

This is a **Java-based food delivery management system** that handles customer orders, calculates prices with discounts, manages delivery addresses and customer records, and performs data analytics on order patterns and payment methods.

The system is implemented using **object-oriented programming** (OOP) principles and demonstrates the use of **custom data structures**: Linked Lists and Queues.

---

## 🧠 Key Features

### 📦 Customer Order Management
- Stores customer information: Name, Phone, Email
- Handles food and drink orders with IDs, names, and prices
- Manages delivery address details (street, city, ZIP)
- Supports multiple payment methods (Cash / Online)

### 💰 Pricing & Discounts
- Calculates total price for orders
- Applies discounts based on payment method
  - Online: Discount applied
  - Cash: No discount
- Shows pricing before and after discounts

### 📊 Data Analysis
- Tracks most and least popular food/drink categories
- Calculates average order value
- Analyzes payment method trends

### 👤 Customer Management
- Search and display customer records
- Update customer phone/address
- Remove customer from the system

---

## 🧱 Technical Overview

### 📚 Core Classes

- **Customer.java**  
  Represents a complete order with composition of Food, Drink, Delivery, and Payment objects.

- **Food.java** / **Drink.java**  
  Represent menu items with simple getters/setters.

- **Delivery.java**  
  Stores address information.

- **Payment.java**  
  Handles payment logic and discount calculations.

### 📂 Data Structures

- **LinkedList.java**  
  Custom singly linked list implementation supporting:
  - Add
  - Remove
  - Search

- **Queue.java**  
  Queue implementation built on top of the LinkedList.
  - Follows FIFO logic

---

## 🔍 Main Programs

- **TestLinkedList.java**  
  Implements core features using LinkedList.

- **TestQueue.java**  
  Alternate implementation using Queue.

- **TestLinkedListNEW.java**  
  Enhanced version with:
  - Grouping by payment method
  - Monthly reporting features
  - Improved user interface (console-based)

---

## 💾 How to Use

### 📌 Prerequisites
- Java installed on your system
- Place `customer.txt` file in the same directory as the `.java` files

### 🛠️ Setup & Compile
```bash
javac *.java
