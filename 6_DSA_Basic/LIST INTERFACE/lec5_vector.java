
// Vector in Java Collection Framework
// The Vector class is a part of the List interface in the Java Collections Framework. It's a growable array of objects, similar to ArrayList, but with some differences — especially in thread safety and synchronization.


// Internal Implementation of Vector
// Internally, Vector uses a resizable array to store elements.
// It is synchronized, meaning only one thread can access a method at a time, which makes it thread-safe but slower in a single-threaded environment compared to ArrayList.
// The initial capacity is 10 by default, and when full, it doubles its size.



// VECTOR VS ARRAYLIST 
// | Feature         | Vector                 | ArrayList                |
// | --------------- | ---------------------- | ------------------------ |
// | Synchronization | Yes                    | No                       |
// | Performance     | Slower (thread-safety) | Faster (non-thread-safe) |
// | Growth          | Doubles size           | Grows by 50%             |


import java.util.Enumeration;
import java.util.Vector;

public class lec5_vector {
     public static void main(String[] args) {
        // Create a Vector
        Vector<String> vec = new Vector<>();

        // Add elements
        vec.add("Apple");
        vec.add("Banana");
        vec.add("Cherry");
        System.out.println("After adding: " + vec);

        // Add at specific index
        vec.add(1, "Blueberry");
        System.out.println("After inserting at index 1: " + vec);

        // Get and set
        System.out.println("Element at index 2: " + vec.get(2));
        vec.set(2, "Coconut");
        System.out.println("After setting index 2: " + vec);

        // Remove by index and object
        vec.remove(0);
        System.out.println("After removing index 0: " + vec);
        vec.remove("Cherry");
        System.out.println("After removing 'Cherry': " + vec);

        // Check if contains
        System.out.println("Contains Banana? " + vec.contains("Banana"));

        // First and last element
        System.out.println("First element: " + vec.firstElement());
        System.out.println("Last element: " + vec.lastElement());

        // Size and capacity
        System.out.println("Size: " + vec.size());
        System.out.println("Capacity: " + vec.capacity());

        // Enumeration
        System.out.print("Using Enumeration: ");
        Enumeration<String> e = vec.elements();
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + " ");
        }

        // Clear all
        vec.clear();
        System.out.println("\nAfter clearing: " + vec);
    }

}



// Commonly Used Methods and Their Time Complexity
// | Method                | Description                            | Time Complexity  |
// | --------------------- | -------------------------------------- | ---------------- |
// | `add(E e)`            | Adds element at end                    | O(1) (amortized) |
// | `add(int index, E e)` | Inserts element at index               | O(n)             |
// | `get(int index)`      | Retrieves element at index             | O(1)             |
// | `set(int index, E e)` | Updates element at index               | O(1)             |
// | `remove(int index)`   | Removes element at index               | O(n)             |
// | `remove(Object o)`    | Removes first occurrence of the object | O(n)             |
// | `contains(Object o)`  | Checks if element exists               | O(n)             |
// | `isEmpty()`           | Checks if vector is empty              | O(1)             |
// | `size()`              | Returns number of elements             | O(1)             |
// | `clear()`             | Removes all elements                   | O(n)             |
// | `firstElement()`      | Returns first element                  | O(1)             |
// | `lastElement()`       | Returns last element                   | O(1)             |
// | `elements()`          | Returns enumeration of the elements    | O(1)             |
// | `capacity()`          | Current capacity of vector             | O(1)             |




// Summary
// Vector is synchronized and thread-safe, best used in multi-threaded environments.
// Internally uses a dynamic array, like ArrayList.
// Slower in performance compared to ArrayList for single-threaded apps.
// Offers legacy support, but not preferred in modern Java unless thread-safety is a must.