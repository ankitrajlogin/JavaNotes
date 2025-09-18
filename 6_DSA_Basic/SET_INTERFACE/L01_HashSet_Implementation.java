


import java.util.LinkedList;

class MyHashSet<E> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private LinkedList<E>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    // Hash function
    private int getBucketIndex(E key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // Add element
    public boolean add(E key) {
        int index = getBucketIndex(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
            size++;

            if ((1.0 * size) / buckets.length > LOAD_FACTOR) {
                rehash();
            }
            return true;
        }
        return false; // Duplicate not allowed
    }

    // Remove element
    public boolean remove(E key) {
        int index = getBucketIndex(key);

        if (buckets[index] != null && buckets[index].contains(key)) {
            buckets[index].remove(key);
            size--;
            return true;
        }
        return false;
    }

    // Check if element exists
    public boolean contains(E key) {
        int index = getBucketIndex(key);

        return buckets[index] != null && buckets[index].contains(key);
    }

    // Get size
    public int size() {
        return size;
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Rehash (when load factor exceeded)
    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<E>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;

        for (LinkedList<E> bucket : oldBuckets) {
            if (bucket != null) {
                for (E key : bucket) {
                    add(key); // reinsert into new bucket
                }
            }
        }
    }
}




public class L01_HashSet_Implementation {
     public static void main(String[] args) {
        MyHashSet<String> set = new MyHashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Banana"); // Duplicate ignored

        System.out.println("Contains Apple? " + set.contains("Apple")); // true
        System.out.println("Contains Mango? " + set.contains("Mango")); // false

        System.out.println("Set size: " + set.size()); // 3

        set.remove("Banana");
        System.out.println("Set size after removing Banana: " + set.size()); // 2

        System.out.println("Is set empty? " + set.isEmpty()); // false
    }
    
}




//  SUMMARY TABLE OF METHODS 
/*

| Method            | Description                              | Avg. Time Complexity | Worst-case Time Complexity |
| ----------------- | ---------------------------------------- | -------------------- | -------------------------- |
| `add(E key)`      | Adds element if not already present      | O(1)                 | O(n)                       |
| `remove(E key)`   | Removes element if present               | O(1)                 | O(n)                       |
| `contains(E key)` | Checks if element exists                 | O(1)                 | O(n)                       |
| `size()`          | Returns number of elements               | O(1)                 | O(1)                       |
| `isEmpty()`       | Checks if set is empty                   | O(1)                 | O(1)                       |
| `rehash()`        | Doubles capacity and re-inserts elements | Amortized O(1)       | O(n)                       |

 */
