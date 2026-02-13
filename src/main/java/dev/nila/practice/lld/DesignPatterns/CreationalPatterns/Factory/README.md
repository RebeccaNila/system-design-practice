# Factory Design Pattern - Food App Example

Factory Design Pattern is a creational design pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created.

- It abstracts the object creation process.
- Helps in creating objects without exposing the instantiation logic to the client.
- The client only interacts with the common interface, not the concrete classes.

> **Factory Design Pattern** – Provides an interface for creating an object while allowing subclasses to decide which class to instantiate.

---

## 📦 Core Concepts

* **Abstraction / Interface** – Represents the *factory* that defines a method for object creation.
* **Concrete Implementation** – Specific factories (e.g., `PizzaFactory`, `BurgerFactory`) that produce concrete products.
* **Product** – The objects being created (e.g., `Pizza`, `Burger`, `Pasta`).
* **Client** – The entity that requests an object (e.g., `Customer`).
* **Mediator** – In the example, the *Waiter* acts as a middle-man, forwarding the request to the appropriate factory.

---

## 🔧 Problem Without a Factory

You're building a food delivery app where users can order different dishes like Pizza, Burger, or Pasta. Instead of creating food items directly using `new`, we delegate the creation logic to factories.

The client directly instantiates concrete classes (e.g., `new Pizza()`), leading to:

* **Violation of the Open/Closed Principle** – Code must be modified to add new product types.
* **Tight coupling** between the client and concrete product classes.


---

## ✅ Solution With a Factory

The client interacts only with the factory interface:

* **Decouples** the client from concrete product classes.
* Allows new product types (e.g., `Pasta`) to be added **without modifying client code**.
* Improves adherence to the **Open/Closed Principle**, though the transcript notes the principle is still not fully satisfied.

- Follows Open/Closed Principle (OCP)
- Removes object creation logic from the client
- Easier to extend and test
---

## ☑️ Components of Factory Method Design Pattern
- Product: Represents the interface of the objects created by the factory method.
- ConcreteProduct: Implements the WithFactoryPattern.Product interface and represents the concrete objects created by the factory method.
- Creator: Declares the factory method, which returns an instance of the WithFactoryPattern.Product interface.
- ConcreteCreator: Implements the factory method to create instances of WithFactoryPattern.ConcreteProduct.

---


## 🏗️ Structure

- **Product**: `Food`
- **Concrete Products**: `Pizza`, `Burger`, `Pasta`
- **Creator Interface**: `FoodFactory`
- **Concrete Creators**: `PizzaFactory`, `BurgerFactory`, `PastaFactory`
- **Client**: `FoodApp` (main app)


---

## 📊 Comparison: Without vs. With Factory

| Aspect | Without Factory | With Factory |
| :--- | :--- | :--- |
| **Object Creation** | Direct instantiation by client (e.g., `new Pizza()`) | Client requests product via factory method |
| **Coupling** | **High** – client knows concrete classes | **Low** – client depends on abstract factory |
| **Open/Closed Principle** | **Violated** – adding a new food requires client changes | **Better** – new factories can be added without touching client |
| **Responsibility** | Client handles creation & selection | Factory (or Waiter) handles creation, client only uses product |

---

## 👨‍🍳 Example Roles in the Restaurant Metaphor

Using a restaurant analogy helps visualize how the components interact:

* **Customer** – The client that wants a food item.
* **Waiter** – Acts as the *factory* (middleman) that receives orders and delegates creation.
* **PizzaFactory / BurgerFactory / PastaFactory** – Concrete factories that produce the respective food objects.
* **Food Objects (Pizza, Burger, Pasta)** – Concrete products delivered to the customer.


---


> Using a **factory** separates what is needed (a food item) from how it is created, leading to more maintainable and extensible code.