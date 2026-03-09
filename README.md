The project demonstrates manual implementation of common abstract data types without using Java's built-in collections framework.

## Implemented Data Structures

### 1. Array-Based Map (M)
A key-value container where each key is unique.

Features:
- Generic implementation using Java generics
- Keys stored in sorted order
- Binary search for lookup
- Dynamic array resizing
- Insertion using insertion-sort logic

Operations:
- `put(K key, V value)`
- `get(K key)`
- `remove(K key)`
- `keySet()`
- `values()`
- `size()`
- `isEmpty()`

Time complexity:
- Search: **O(log n)**
- Insert: **O(n)** (due to shifting elements)
- Remove: **O(n)**

---

### 2. Sorted Multimap (D)
A container that allows **multiple values per key**.

Features:
- Generic implementation
- Dynamic array storage
- Merge sort used to return sorted keys
- Supports duplicate keys

Operations:
- `insert(K key, V value)`
- `findAll(K key)`
- `removeAll(K key)`
- `keys()`
- `size()`
- `isEmpty()`

Time complexity:
- Insert: **O(1)** amortized
- Find all values: **O(n)**
- Remove all: **O(n)**

---

## Concepts Demonstrated

- Abstract Data Types (ADT)
- Java Generics
- Dynamic arrays
- Binary Search
- Insertion sort (for ordered insertion)
- Merge sort implementation
- Object-oriented design
- Inner classes

## Extended Implementations

### Extended Map (ME)

Adds additional functionality to the base Map:

- containsKey(K key)
- containsValue(V value)
- valueSet()

valueSet() returns sorted unique values using an auxiliary Map.

---

### Extended Sorted Multimap (ESD)

Extends the SortedMultimap with additional operations:

- contains(K key)
- keySet() → unique sorted keys
- valueSet() → sorted unique values

Demonstrates inheritance and extension of abstract data structures.

---

## Author

**Amr Shaarawy**

Information Engineering Student  
University of Padova

GitHub: https://github.com/amrashaarawy  
LinkedIn: https://www.linkedin.com/in/amr-shaarawy
