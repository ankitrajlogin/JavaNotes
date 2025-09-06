

/*
1.  Introduction
        - HashMap<K,V> is a class in java.util that implements the Map interface.
        - It stores elements in key-value pairs using hashing technique.
        - Keys are unique, values can be duplicate.
        - Based on hash table (array of buckets + linked list / balanced tree since Java 8).

2.  Features
        - Nulls:
            - One null key allowed.
            - Multiple null values allowed.
        - Not synchronized: Not thread-safe (use Collections.synchronizedMap() for sync).
        - Ordering: Does not maintain any order of keys.
        - Load Factor: Default 0.75. Controls resizing of hashmap.
        - Initial Capacity: Default 16. Doubles when threshold exceeded.

3.  Internal Working
    Hashing: HashMap computes hashCode() of key → reduces it to bucket index.
    Collision Handling:
        Pre Java 8: Collision resolved using Linked List in each bucket.
        Java 8+: If chain length > 8, converts to Balanced Tree (Red-Black Tree) for faster lookup.

    Load Factor: When (size > capacity × loadFactor) → HashMap resizes (doubles capacity).
    Key Equality: HashMap uses hashCode() + equals() to ensure uniqueness of keys.



4.  Method of HashMap 

| Method                        | Description                  | Average Time Complexity | Worst Case                             |
| ----------------------------- | ---------------------------- | ----------------------- | -------------------------------------- |
| `put(K key, V value)`         | Inserts mapping              | **O(1)**                | O(n) (all keys in same bucket → chain) |
| `get(Object key)`             | Returns value for key        | **O(1)**                | O(n)                                   |
| `remove(Object key)`          | Removes mapping              | **O(1)**                | O(n)                                   |
| `containsKey(Object key)`     | Checks if key exists         | **O(1)**                | O(n)                                   |
| `containsValue(Object value)` | Checks if value exists       | **O(n)**                | O(n)                                   |
| `size()`                      | Returns number of entries    | **O(1)**                | O(1)                                   |
| `isEmpty()`                   | Checks if empty              | **O(1)**                | O(1)                                   |
| `clear()`                     | Removes all entries          | **O(1)**                | O(1)                                   |
| `putAll(Map m)`               | Copies mappings              | **O(n)**                | O(n)                                   |
| `keySet()`                    | Returns Set of keys          | **O(1)**                | O(1)                                   |
| `values()`                    | Returns Collection of values | **O(1)**                | O(1)                                   |
| `entrySet()`                  | Returns Set of entries       | **O(1)**                | O(1)                                   |


    
 */

import java.util.HashMap;
import java.util.*; 

public class L01_HashMap {
    public static void main(String[] args){
        // Creating HashMap 
        HashMap<Integer , String > map = new HashMap<>() ;

        // put() -> Insert key-value pairs ; 
        map.put(1 , "Apple") ; 
        map.put(2, "Banana");
        map.put(3, "Mango");
        map.put(2, "Grapes"); // Duplicate key overwrites value

        System.out.println("\nMap : " + map)  ;

        // get() -> fetch value 
        System.out.println("\nKey 2 maps to : " + map.get(2)) ; 


        // containsKey() 
        System.out.println("\nContains Key 3 ? : " + map.containsKey(3)) ; 

        // containsValue()
        System.out.println("\nContains value 'Apple'? " + map.containsValue("Apple"));


        // remove()
        map.remove(1);
        System.out.println("\nAfter removing key 1: " + map);


        // Iterating using entryset() 
        for(Map.Entry<Integer , String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue()); 
        }


        // keySet() and values()
        System.out.println("\nKeys: " + map.keySet());
        System.out.println("\nValues: " + map.values());



    }

    
}


/*
6.  Related Terms
        - Bucket: Storage location inside HashMap (array index).
        - Hash Function: Converts key’s hashCode into bucket index.
        - Collision: When two keys map to the same bucket.
        - Load Factor: Controls when resizing happens.
        - Rehashing: Process of resizing + redistributing entries.
        - Treeification: Converting bucket’s linked list into a balanced tree (Java 8+).
        - Threshold: capacity × loadFactor → max allowed entries before resizing.
 */
