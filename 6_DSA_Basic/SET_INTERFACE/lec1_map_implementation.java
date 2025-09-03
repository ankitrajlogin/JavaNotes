
package SET_INTERFACE;

import java.util.Objects;

// Explanation of HashMap Implementation
// Overview:
// HashMap<K, V> is a part of Java’s Map interface, and it's used to store key-value pairs.
// Keys are unique.
// Values can be duplicate.
// Under the hood, HashMap uses an array of buckets, where each bucket is a LinkedList (in Java 7) or a Balanced Tree (from Java 8 onwards) to handle hash collisions.



class CustomHashMap<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16;
    private Entry<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new Entry[SIZE];
    }

    private int getBucketIndex(K key) {
        return Math.abs(Objects.hashCode(key)) % SIZE;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> newNode = new Entry<>(key, value);
        Entry<K, V> current = buckets[index];

        if (current == null) {
            buckets[index] = newNode;
            return;
        }

        Entry<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value; // update value
                return;
            }
            prev = current;
            current = current.next;
        }

        prev.next = newNode; // append to end
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public boolean remove(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> current = buckets[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            Entry<K, V> current = buckets[i];
            System.out.print("Bucket " + i + ": ");
            while (current != null) {
                System.out.print("[" + current.key + " = " + current.value + "] -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

}


public class lec1_map_implementation {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("apple", 100);
        map.put("banana", 200);
        map.put("orange", 300);
        map.put("apple", 500); // update

        map.display();

        System.out.println("\nGet value for 'banana': " + map.get("banana"));

        System.out.println("\nRemoving 'orange': " + map.remove("orange"));
        map.display();
    }
    
}


// Common Collision Handling Techniques

// 1. Chaining (Separate Chaining)
// Each bucket contains a list (or a LinkedList / Tree in Java).
// All elements that hash to the same index are stored in that list.

// 🔧 Used in Java's HashMap
// Pros: Easy to implement, handles high number of collisions
// Cons: Requires extra memory for linked nodes


// 2. Open Addressing
// All elements are stored in the array itself.
// If a collision occurs, we search for the next empty slot (probing).\
// 🔁 Types of Probing:
// Linear Probing: index = (hash + i) % size
// Quadratic Probing: index = (hash + i^2) % size
// Double Hashing: index = (hash1 + i * hash2) % size

// Pros: No need for extra data structures
// Cons: Clustering issue, resizing is costly

