



/*
-------------
TREESET 
-------------
TreeSet is based on a balanced binary search tree (Red-Black Tree), so it keeps elements in sorted (natural or custom) order.


2. Constructors
    - TreeSet() → Natural ordering.
    - TreeSet(Comparator comp) → Custom comparator ordering.


3. Common Methods of TreeSet and Time Complexity

| Method                     | Description                            | Avg. Complexity |
| -------------------------- | -------------------------------------- | --------------- |
| `add(E e)`                 | Adds element (keeps sorted)            | **O(log n)**    |
| `remove(Object o)`         | Removes element                        | **O(log n)**    |
| `contains(Object o)`       | Checks if element exists               | **O(log n)**    |
| `size()`                   | Returns number of elements             | **O(1)**        |
| `isEmpty()`                | Checks if set is empty                 | **O(1)**        |
| `clear()`                  | Removes all elements                   | **O(n)**        |
| `first()`                  | Returns smallest element               | **O(log n)**    |
| `last()`                   | Returns largest element                | **O(log n)**    |
| `higher(E e)`              | Returns least element greater than `e` | **O(log n)**    |
| `lower(E e)`               | Returns greatest element less than `e` | **O(log n)**    |
| `ceiling(E e)`             | Returns least element ≥ `e`            | **O(log n)**    |
| `floor(E e)`               | Returns greatest element ≤ `e`         | **O(log n)**    |
| `pollFirst()`              | Removes & returns smallest element     | **O(log n)**    |
| `pollLast()`               | Removes & returns largest element      | **O(log n)**    |
| `headSet(E toElement)`     | Returns subset before `toElement`      | **O(log n)**    |
| `tailSet(E fromElement)`   | Returns subset after `fromElement`     | **O(log n)**    |
| `subSet(E from, E to)`     | Returns elements between range         | **O(log n)**    |
| `iterator()`               | Iterator in ascending order            | **O(1)**        |
| `descendingIterator()`     | Iterator in descending order           | **O(1)**        |
| `forEach(Consumer action)` | Iterates using lambda                  | **O(n)**        |
| `toArray()`                | Converts to array                      | **O(n)**        |



 */


import java.util.* ; 


public class L05_TreeSet {
      public static void main(String[] args) {
        // 1. Create TreeSet (natural ordering)
        TreeSet<Integer> set = new TreeSet<>();

        // 2. add()
        set.add(50);
        set.add(10);
        set.add(30);
        set.add(20);
        set.add(40);
        System.out.println("TreeSet (sorted): " + set);

        // 3. contains()
        System.out.println("Contains 30? " + set.contains(30));

        // 4. first() and last()
        System.out.println("First: " + set.first());
        System.out.println("Last: " + set.last());

        // 5. higher(), lower(), ceiling(), floor()
        System.out.println("Higher than 20: " + set.higher(20));
        System.out.println("Lower than 20: " + set.lower(20));
        System.out.println("Ceiling of 25: " + set.ceiling(25));
        System.out.println("Floor of 25: " + set.floor(25));

        // 6. pollFirst() and pollLast()
        System.out.println("PollFirst: " + set.pollFirst());
        System.out.println("PollLast: " + set.pollLast());
        System.out.println("After polling: " + set);

        // 7. headSet(), tailSet(), subSet()
        set.addAll(Arrays.asList(5, 15, 35, 45, 60));
        System.out.println("HeadSet(30): " + set.headSet(30));
        System.out.println("TailSet(30): " + set.tailSet(30));
        System.out.println("SubSet(15, 45): " + set.subSet(15, 45));

        // 8. Iteration (ascending)
        System.out.println("Ascending iteration:");
        for (int num : set) {
            System.out.println(num);
        }

        // 9. Descending iteration
        System.out.println("Descending iteration:");
        Iterator<Integer> descIt = set.descendingIterator();
        while (descIt.hasNext()) {
            System.out.println(descIt.next());
        }
    }
}
