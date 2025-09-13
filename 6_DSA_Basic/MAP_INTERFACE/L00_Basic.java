/*
    ===========================
    MAP INTERFACE IN JAVA (NOTES)
    ===========================

    1. Introduction:
        - Map<K, V> is an interface in java.util package.
        - Represents a collection of key-value pairs (entries).
        - Keys are unique, values can be duplicated.
        - Not a subtype of Collection (independent interface).
        - Each mapping is internally represented as an Entry<K, V>.

    2. Key Features:
        - Stores data as (key, value) pairs.
        - No duplicate keys allowed.
        - Allows null values and, depending on implementation, null keys.
        - Commonly used for lookups, dictionaries, and associative arrays.
        - Provides three views:
                - keySet() → Set of all keys
                - values() → Collection of values
                - entrySet() → Set of key-value pairs (Map.Entry)

    3. Important Methods:

        // Basic Operations
        - V put(K key, V value): Adds a key-value pair to the map. [O(1) avg]
        - V get(Object key): Returns the value associated with the key. [O(1) avg]
        - V remove(Object key): Removes the mapping for the key. [O(1) avg]
        - boolean containsKey(Object key): Checks if a key exists. [O(1) avg]
        - boolean containsValue(Object value): Checks if a value exists. [O(n)]
        - int size(): Returns the number of key-value pairs. [O(1)]
        - boolean isEmpty(): Checks if the map is empty. [O(1)]
        - void clear(): Removes all mappings. [O(n)]

        // Bulk Operations
        - void putAll(Map<? extends K,? extends V> m): Copies all mappings from the specified map to this map. [O(n)]

        // Views
        - Set<K> keySet(): Returns a Set of all keys. [O(1)]
        - Collection<V> values(): Returns a Collection of all values. [O(1)]
        - Set<Map.Entry<K,V>> entrySet(): Returns a Set of all key-value pairs. [O(1)]

        // Java 8+ Default Methods
        - V getOrDefault(Object key, V defaultValue): Returns value for key, or defaultValue if not found. [O(1)]
        - V putIfAbsent(K key, V value): Puts value if key is absent. [O(1)]
        - boolean remove(Object key, Object value): Removes entry if key maps to value. [O(1)]
        - boolean replace(K key, V oldValue, V newValue): Replaces value only if currently mapped to oldValue. [O(1)]
        - V replace(K key, V value): Replaces value for key if present. [O(1)]
        - void forEach(BiConsumer<? super K,? super V> action): Performs action for each entry. [O(n)]
        - void replaceAll(BiFunction<? super K,? super V,? extends V> function): Replaces each value with result of function. [O(n)]

        // Entry Interface
        - K getKey(): Returns the key for this entry. [O(1)]
        - V getValue(): Returns the value for this entry. [O(1)]
        - V setValue(V value): Replaces the value for this entry. [O(1)]

        *Note: Time complexities are for HashMap (average case). TreeMap operations are O(log n).



    4. Implementations:
        - HashMap:
            * Most commonly used implementation.
            * No order is guaranteed.
            * Allows one null key and multiple null values.
            * Not synchronized (not thread-safe).
        - LinkedHashMap:
            * Maintains insertion order.
            * Slightly slower than HashMap.
        - TreeMap:
            * Sorted according to the natural ordering of keys or by a Comparator.
            * Does not allow null keys.
        - Hashtable:
            * Legacy class, synchronized (thread-safe).
            * Does not allow null keys or values.
        - ConcurrentHashMap
            * Thread-safe alternative to HashMap (for multithreading).
            * Uses bucket-level locking instead of locking the whole map.
            * Faster than Hashtable.

    
*/

import java.util.HashMap;
import java.util.Map;

public class L00_Basic {
    public static void main(String[] args) {
        // HashMap Example
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        // Basic Ops
        System.out.println("Apple count: " + map.get("Apple")); // get()
        System.out.println("Contains key 'Banana'? " + map.containsKey("Banana")); // containsKey()
        System.out.println("Contains value 30? " + map.containsValue(30)); // containsValue()
        System.out.println("Size: " + map.size()); // size()
        System.out.println("Is map empty? " + map.isEmpty()); // isEmpty()
        map.remove("Banana"); // remove(key)
        System.out.println("After removing 'Banana': " + map);

        // Bulk Ops
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Grapes", 40);
        map2.put("Mango", 50);
        map.putAll(map2); // putAll()
        System.out.println("After putAll: " + map);

        // Views
        System.out.println("Keys: " + map.keySet()); // keySet()
        System.out.println("Values: " + map.values()); // values()
        System.out.println("Entries: " + map.entrySet()); // entrySet()

        // Java 8+ Defaults
        System.out.println("Get 'Pineapple' or default: " + map.getOrDefault("Pineapple", 0)); // getOrDefault()
        map.putIfAbsent("Apple", 100); // putIfAbsent() - won't overwrite existing
        map.putIfAbsent("Pineapple", 60); // will add
        System.out.println("After putIfAbsent: " + map);

        map.remove("Apple", 10); // remove(key, value) - only removes if mapping exists
        System.out.println("After remove(key, value): " + map);

        map.replace("Orange", 300); // replace(key, value)
        map.replace("Grapes", 40, 400); // replace(key, oldValue, newValue)
        System.out.println("After replace: " + map);

        map.forEach((k, v) -> System.out.println("forEach: " + k + " = " + v)); // forEach()

        map.replaceAll((k, v) -> v + 1); // replaceAll()
        System.out.println("After replaceAll: " + map);

        // Entry Interface
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey(); // getKey()
            Integer value = entry.getValue(); // getValue()
            entry.setValue(value * 2); // setValue()
            System.out.println("Entry: " + key + " = " + entry.getValue());
        }

        // Clear the map
        map.clear(); // clear()
        System.out.println("After clear, is map empty? " + map.isEmpty());
    }
}

/*
    6. When to use Map?
        - When you need to associate unique keys with values.
        - For fast lookups, insertions, and deletions by key.

    7. Differences with other Collections:
        - List and Set store only values, Map stores key-value pairs.
        - Set does not allow duplicates, Map does not allow duplicate keys.

    8. Common Interview Questions:
        - Difference between HashMap and Hashtable.
        - How does HashMap work internally?
        - How to iterate over a Map?
        - Can we use custom objects as keys? (Yes, but must override hashCode() and equals())

    9. Useful Tips:
        - Always choose the right implementation based on requirements (ordering, sorting, thread-safety).
        - Be careful with mutable keys.

    ===========================
    END OF NOTES
    ===========================
*/
