

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// The Set interface in Java is a part of the Java Collections Framework and is used to store a collection of unique elements, i.e., no duplicates allowed.



// **********************
// public interface Set<E> extends Collection<E>

// It extends the Collection interface, meaning it inherits common collection methods like add(), remove(), contains(), size(), etc., but adds its own constraint: all elements must be unique.

// **********************



// Key Features of Set 
// | Feature                   | Description                                    |
// | ------------------------- | ---------------------------------------------- |
// | ✅ No Duplicates           | It does not allow duplicate elements.          |
// | ❌ No Positional Access    | Unlike List, it doesn’t support indexing.      |
// | ✅ Null Allowed            | One null element is allowed (depends on type). |
// | 🚫 Unordered (in HashSet) | No guarantee of insertion order.               |






// 2. Set Interface
        // 🔹 Unordered, no duplicates
        // 👉 Common Implementations:
        // HashSet
        // LinkedHashSet
        // TreeSet (SortedSet)

public class lec0_set_interface {
        public static void main(String[] args) {
        // HashSet
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Apple"); // Duplicate
        System.out.println("HashSet: " + hashSet); // Unordered, no duplicates

        // LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Cherry");
        System.out.println("LinkedHashSet: " + linkedHashSet); // Maintains insertion order

        // TreeSet
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Cherry");
        System.out.println("TreeSet: " + treeSet); // Sorted order

        // Common Methods
        System.out.println("TreeSet contains 'Apple': " + treeSet.contains("Apple"));
        treeSet.remove("Apple");
        System.out.println("After removing 'Apple': " + treeSet);
        System.out.println("TreeSet size: " + treeSet.size());
        treeSet.clear();
        System.out.println("TreeSet after clear(): " + treeSet);
        System.out.println("TreeSet is empty: " + treeSet.isEmpty());
    }
    
}


// when to use set 

// | Use Case                           | Set Type        |
// | ---------------------------------- | --------------- |
// | Unique values without order        | `HashSet`       |
// | Unique values with insertion order | `LinkedHashSet` |
// | Unique values in sorted order      | `TreeSet`       |

