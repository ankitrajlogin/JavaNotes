
// What is ArrayList?
// ArrayList is a resizable array implementation of the List interface in Java. Unlike arrays in Java, whose size is fixed, an ArrayList can grow or shrink dynamically.

// 👉 Key Points:
// Maintains insertion order
// Allows duplicate elements\
// Not synchronized (not thread-safe by default)
// Random access is fast (like arrays)

// Growth Strategy:
// When the internal array fills up, a new array is created with 1.5x the previous size, and all elements are copied to it.


// IMPORTANT METHODS AND TIME COMPLEXITY 
// | Method                | Description                | Time Complexity      |
// | --------------------- | -------------------------- | -------------------- |
// | `add(E e)`            | Appends element            | **O(1)** (amortized) |
// | `add(int index, E e)` | Inserts at index           | **O(n)**             |
// | `remove(int index)`   | Removes element by index   | **O(n)**             |
// | `remove(Object o)`    | Removes first occurrence   | **O(n)**             |
// | `get(int index)`      | Returns element at index   | **O(1)**             |
// | `set(int index, E e)` | Replaces element at index  | **O(1)**             |
// | `contains(Object o)`  | Checks presence            | **O(n)**             |
// | `indexOf(Object o)`   | First index of element     | **O(n)**             |
// | `clear()`             | Removes all elements       | **O(n)**             |
// | `size()`              | Returns number of elements | **O(1)**             |
// | `isEmpty()`           | Checks if empty            | **O(1)**             |

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class lec1_ArrayList {

    public static void main(String[] args){

        // Creating an ArrayList of Strings
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Initial List: " + list); // []

        // add(E e): Adds element to the end - O(1) amortized
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("After add(): " + list); // [Apple, Banana, Cherry]

        // add(int index, E element): Inserts element at index - O(n)
        list.add(1, "Blueberry");
        System.out.println("After add at index 1: " + list); // [Apple, Blueberry, Banana, Cherry]

        // get(int index): Get element at index - O(1)
        String fruit = list.get(2);
        System.out.println("Element at index 2: " + fruit); // Banana

        // set(int index, E element): Replace element at index - O(1)
        list.set(2, "Blackberry");
        System.out.println("After set at index 2: " + list); // [Apple, Blueberry, Blackberry, Cherry]

        // contains(Object o): Check if element exists - O(n)
        boolean hasCherry = list.contains("Cherry");
        System.out.println("Contains 'Cherry': " + hasCherry); // true

        // indexOf(Object o): First index of element - O(n)
        int index = list.indexOf("Blueberry");
        System.out.println("Index of 'Blueberry': " + index); // 1

        // remove(Object o): Removes first occurrence - O(n)
        list.remove("Blueberry");
        System.out.println("After removing 'Blueberry': " + list); // [Apple, Blackberry, Cherry]

        // remove(int index): Removes element at index - O(n)
        list.remove(1);
        System.out.println("After removing at index 1: " + list); // [Apple, Cherry]

        // isEmpty(): Check if list is empty - O(1)
        System.out.println("Is list empty? " + list.isEmpty()); // false

        // size(): Get size - O(1)
        System.out.println("Size of list: " + list.size()); // 2

        // clear(): Remove all elements - O(n)
        list.clear();
        System.out.println("After clear(): " + list); // []

        System.out.println("Is list empty now? " + list.isEmpty()); // true


        // Thread-Safe Alternative
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        // Or use:
        CopyOnWriteArrayList<String>synclist2 = new CopyOnWriteArrayList<>();

        System.out.println(syncList) ; 
        System.out.println(synclist2) ; 

    }
}




// Advantages:
// Dynamic resizing
// Easy to use
// Fast random access (get())

// 🛑 Disadvantages:
// Insertion/deletion from middle or beginning is slow
// Not thread-safe (must use Collections.synchronizedList() or CopyOnWriteArrayList)


