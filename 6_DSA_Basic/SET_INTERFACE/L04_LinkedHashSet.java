



//  METHODS of LinkedHashSet 
// -----------------------------------------

/*

| Method                     | Description                                  | Example                                 | Avg. Time Complexity |
| -------------------------- | -------------------------------------------- | --------------------------------------- | -------------------- |
| `add(E e)`                 | Adds an element if not already present       | `set.add("Apple")`                      | O(1)                 |
| `remove(Object o)`         | Removes an element if present                | `set.remove("Apple")`                   | O(1)                 |
| `contains(Object o)`       | Checks if element exists                     | `set.contains("Apple")`                 | O(1)                 |
| `size()`                   | Returns number of elements                   | `set.size()`                            | O(1)                 |
| `isEmpty()`                | Checks if set is empty                       | `set.isEmpty()`                         | O(1)                 |
| `clear()`                  | Removes all elements                         | `set.clear()`                           | O(n)                 |
| `iterator()`               | Returns iterator maintaining insertion order | `Iterator<String> it = set.iterator();` | O(1)                 |
| `forEach(Consumer action)` | Iterates using lambda                        | `set.forEach(System.out::println);`     | O(n)                 |
| `toArray()`                | Converts set to array                        | `Object[] arr = set.toArray();`         | O(n)                 |
| `spliterator()`            | Returns Spliterator for parallel iteration   | `set.spliterator()`                     | O(1)                 |
| `addAll(Collection c)`     | Adds all elements from another collection    | `set.addAll(list);`                     | O(m)                 |

 */


import java.util.*;


public class L04_LinkedHashSet {
   
    public static void main(String[] args) {
        // Create LinkedHashSet
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // 1. add()
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Orange");
        set.add("Banana"); // duplicate ignored
        System.out.println("After add(): " + set);

        // 2. contains()
        System.out.println("Contains Mango? " + set.contains("Mango"));

        // 3. size()
        System.out.println("Size: " + set.size());

        // 4. isEmpty()
        System.out.println("Is set empty? " + set.isEmpty());

        // 5. remove()
        set.remove("Banana");
        System.out.println("After remove(): " + set);

        // 6. iterator()
        System.out.println("Using Iterator:");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 7. forEach (Java 8+)
        System.out.println("Using forEach lambda:");
        set.forEach(fruit -> System.out.println(fruit));

        // 8. Stream API
        System.out.println("Using Stream:");
        set.stream().filter(f -> f.startsWith("A")).forEach(System.out::println);

        // 9. toArray()
        Object[] arr = set.toArray();
        System.out.println("Converted to Array: " + Arrays.toString(arr));

        // 10. spliterator()
        System.out.println("Using Spliterator:");
        Spliterator<String> sp = set.spliterator();
        sp.forEachRemaining(System.out::println);

        // 11. addAll()
        List<String> newFruits = Arrays.asList("Grapes", "Pineapple");
        set.addAll(newFruits);
        System.out.println("After addAll(): " + set);

        // 12. clear()
        set.clear();
        System.out.println("After clear(), size = " + set.size());
    }
}

    
