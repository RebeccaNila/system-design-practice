# Singleton Design Pattern in Java

The **Singleton pattern** ensures that a class has **only one instance** and provides a **global access point** to it.

---

## 📌 Key Characteristics of Singleton Pattern

- ✔ **Single Instance:** Only one object of the class exists in memory.
- ✔ **Global Access:** Provides a static method to get the instance.
- ✔ **Lazy or Eager Initialization:** Object is created **only when needed** (lazy) or **at class loading** (eager).
- ✔ **Thread Safety:** Ensures instance is created safely in **multithreaded environments**.

---

## 📌 Real-World Examples of Singleton Design Pattern

- ✔ Database Connection Pool – Manages database connections through a single shared instance.
- ✔ Logger – Centralized logging through a single logger instance.
- ✔ Configuration Manager – Provides global access to application configuration settings.
- ✔ Thread Pool – Controls access to a shared pool of threads.
- ✔ Cache – Maintains a single in-memory store for frequently used data.
- ✔ Task Manager (OS) – Single instance monitors and manages system processes.
- ✔ Spring Boot Beans – Default scope for Spring beans is singleton, ensuring one shared


# Singleton Pattern Overview

**Singleton** – a design pattern that ensures a class has only one instance and provides a global access point to that instance.

* Guarantees **single object** throughout the application.
* Often used for resources such as configuration managers, thread pools, or logging.

## 🛠 Basic Implementation

* Provide a `static` method (commonly `getInstance`) that returns the sole object.
* Store the instance in a `static variable` shared across all uses.
* **Example flow:**
    1. Call `ClassName.getInstance()`.
    2. If the static variable is `null`, create a new instance.
    3. Return the stored instance.

### Limitations
* **Not thread-safe:** multiple threads may create separate instances simultaneously.
* Works fine in single-threaded contexts but can lead to duplicate objects under concurrency.

---

## 🔒 Thread-Safety Concerns

* Without safeguards, the basic pattern can produce **more than one instance** when accessed concurrently.
* Need mechanisms to prevent race conditions during instance creation.

### ⏱ Synchronized Implementation
* Wrap the instance-creation check inside a **synchronized block** or method.
* Guarantees that only one thread can execute the creation code at a time.

**Drawbacks**
* Introduces a **performance bottleneck** because every call to `getInstance` must acquire the lock, even after the instance is created.

---

## 🚀 Eager (Early) Initialization

* Declare the instance as a `private static final` field, instantiated when the class loads.
* Guarantees thread safety without synchronization overhead.

### Pros & Cons

| Aspect | Eager Initialization |
| :--- | :--- |
| **Thread safety** | ✅ (inherent) |
| **Performance** | ✅ (no locking) |
| **Resource usage** | ❌ (instance created even if never used) |

---

## 🏗 Lazy Initialization with Inner Static Class

* Use a `private static inner class` that holds the singleton instance.
* The inner class is not loaded until `getInstance` is called, achieving **lazy loading**.
* JVM guarantees thread safety for class initialization.

### Advantages
* Combines **lazy loading** with **thread safety** without explicit synchronization.
* Considered one of the most efficient and clean implementations.

---

## 💧 Reflection Vulnerability

* Standard singleton implementations can be broken via **reflection**, which can invoke private constructors.
* Requires additional safeguards (e.g., throwing an exception in the constructor if an instance already exists) to mitigate.

---

## 📊 Implementation Comparison

| Implementation | Thread Safety | Lazy Loading | Performance Impact | Typical Use Case |
| :--- | :---: | :---: | :--- | :--- |
| **Basic (static variable)** | ❌ | ✅ | ✅ (no lock) | Simple, single-threaded apps |
| **Synchronized method** | ✅ | ✅ | ❌ (locking each call) | When simplicity outweighs overhead |
| **Eager (static final)** | ✅ | ❌ | ✅ (no lock) | When instance is always needed |
| **Inner static class (lazy)** | ✅ | ✅ | ✅ (no lock) | Preferred for most scenarios |
| **Reflection-protected** | ✅ | Varies | Varies | Security-critical applications |

---


## 🧠 Best Singleton Approach Based on Use Case

| **Use Case**                                  | **Recommended Approach**               | **Reason**                                      |
|-----------------------------------------------|----------------------------------------|-------------------------------------------------|
| Lightweight Singleton (Logger, ConfigManager) | `enum Singleton`                       | Simple, thread-safe, and secure                 |
| Heavy object (Database Connection, Cache)     | Double-Checked Locking (`volatile`)    | Lazy loading with good performance              |
| Lazy + clean implementation                   | Bill Pugh Singleton                    | JVM-based lazy loading, no sync/volatile needed |
| Requires parameters or dynamic config         | Classic Singleton with custom init     | `enum` doesn't allow passing arguments          |
| Needs inheritance                             | Class-based Singleton (not `enum`)     | `enum` can't extend other classes               |
| High security (avoid reflection/serialization)| `enum Singleton`                       | Fully immune to reflection and deserialization  |

---

## 🧪 Singleton Pattern Comparison Table

| Feature                      | `enum` Singleton | Double-Checked Locking | Bill Pugh Singleton     | Simple `synchronized` |
|-----------------------------|------------------|-------------------------|--------------------------|------------------------|
| Thread-safe                 | ✅ Yes           | ✅ Yes                 | ✅ Yes                   | ✅ Yes                |
| Lazy Initialization         | ❌ No            | ✅ Yes                 | ✅ Yes                   | ✅ Yes                |
| Prevents Reflection Attack  | ✅ Yes           | ❌ No                  | ❌ No (needs guard)      | ❌ No                 |
| Serialization Safe          | ✅ Yes           | ❌ No (needs `readResolve()`) | ❌ No (needs `readResolve()`) | ❌ No         |
| Uses `volatile`             | ❌ No            | ✅ Yes                 | ❌ No                    | ❌ No                 |
| Uses `synchronized`         | ❌ No            | ✅ Yes (conditionally) | ❌ No                    | ✅ Yes                |
| Easy to Implement           | ✅ Easiest       | ❌ Medium              | ✅ Clean & Simple        | ✅ Simple             |
| Good for Heavy Objects      | ❌ Not Ideal     | ✅ Yes                 | ✅ Yes                   | ❌ Less efficient      |
| Constructor Arguments       | ❌ Not possible  | ✅ Yes                 | ✅ Yes                   | ✅ Yes                |

---


## ✅ Recommended Practices

* Choose the **inner static class** approach for a balance of laziness, thread safety, and performance.
* If using basic or synchronized versions, document the concurrency assumptions clearly.
* Consider adding **defensive checks** against reflection if the singleton controls critical resources.