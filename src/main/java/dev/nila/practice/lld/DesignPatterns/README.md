# Design Patterns

## Summary
Design patterns are typical solutions to common problems in software design. Each pattern is like a blueprint that you can customize to solve a particular design problem in your code. They represent best practices used by experienced object-oriented software developers. Design patterns are not code snippets, but rather general concepts for solving recurring problems.

## Categories of Design Patterns

The 23 Gang of Four (GoF) design patterns are generally classified into three categories:

### 1. Creational Patterns
These patterns provide various object creation mechanisms, which increase flexibility and reuse of existing code.

1.  **Singleton**: Ensures that a class has only one instance and provides a global point of access to it.
2.  **Factory Method**: Provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
3.  **Abstract Factory**: Lets you produce families of related objects without specifying their concrete classes.
4.  **Builder**: Lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.
5.  **Prototype**: Lets you copy existing objects without making your code dependent on their classes.

### 2. Structural Patterns
These patterns explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient.

6.  **Adapter**: Allows objects with incompatible interfaces to collaborate.
7.  **Bridge**: Lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently.
8.  **Composite**: Lets you compose objects into tree structures and then work with these structures as if they were individual objects.
9.  **Decorator**: Lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.
10. **Facade**: Provides a simplified interface to a library, a framework, or any other complex set of classes.
11. **Flyweight**: Lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.
12. **Proxy**: Lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.

### 3. Behavioral Patterns
These patterns are concerned with algorithms and the assignment of responsibilities between objects.

13. **Chain of Responsibility**: Lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
14. **Command**: Turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a method arguments, delay or queue a request's execution, and support undoable operations.
15. **Iterator**: Lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).
16. **Mediator**: Lets you reduce chaotic dependencies between objects. The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object.
17. **Memento**: Lets you save and restore the previous state of an object without revealing the details of its implementation.
18. **Observer**: Lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they're observing.
19. **State**: Lets an object alter its behavior when its internal state changes. It appears as if the object changed its class.
20. **Strategy**: Lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.
21. **Template Method**: Defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.
22. **Visitor**: Lets you separate algorithms from the objects on which they operate.
23. **Interpreter**: A way to include language elements in a program to match the grammar of an intended language.
