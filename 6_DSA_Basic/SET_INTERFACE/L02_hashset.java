
/*

1. What is HashSet?
    - HashSet is a class in Java that implements the Set interface using a HashMap internally.
    - It was introduced in Java 1.2 and is part of the Java Collections Framework.
    - Key Features:
        - Stores unique elements only (no duplicates).
        - Allows one null value.
        - Unordered → does not maintain insertion order.
        - Backed by a Hash Table (internally uses HashMap).

2. Core method 

| Method                       | Description                       | Avg. Time Complexity | Worst-Case |
| ---------------------------- | --------------------------------- | -------------------- | ---------- |
| `boolean add(E e)`           | Adds element if not present       | O(1)                 | O(n)       |
| `boolean remove(Object o)`   | Removes element if present        | O(1)                 | O(n)       |
| `boolean contains(Object o)` | Checks if element exists          | O(1)                 | O(n)       |
| `void clear()`               | Removes all elements              | O(1)                 | O(1)       |
| `int size()`                 | Returns number of elements        | O(1)                 | O(1)       |
| `boolean isEmpty()`          | Checks if set is empty            | O(1)                 | O(1)       |
| `Iterator<E> iterator()`     | Returns an iterator for traversal | O(n)                 | O(n)       |
| `Object clone()`             | Returns a shallow copy of HashSet | O(n)                 | O(n)       |

 */

import java.util.HashSet;

public class L02_hashset {
    public static void main(String[] args){
        // create hashset 
        HashSet<String>set = new HashSet<>() ; 

        set.add("Apple") ; 
        set.add("Banana") ; 
        set.add("Orange") ; 

        // Display
        System.out.println("HashSet: " + set);

        // Contains check
        System.out.println("Contains Apple? " + set.contains("Apple"));

        // Remove element
        set.remove("Banana");
        System.out.println("After removing Banana: " + set);

        // Size
        System.out.println("Size: " + set.size());

        // Iterating
        System.out.println("Iterating through set:");
        for (String fruit : set) {
            System.out.println(fruit);
        }

        // Clear
        set.clear();
        System.out.println("Is Empty? " + set.isEmpty());

        
    }
    
}
