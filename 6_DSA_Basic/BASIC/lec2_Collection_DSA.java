package BASIC;


// What is Java Collection Framework?
// The Java Collection Framework (JCF) is a unified architecture for storing and manipulating groups of objects. It includes:
// Interfaces (like List, Set, Map)
// Implementations (like ArrayList, HashSet, HashMap)
// Algorithms (like sorting and searching via Collections class)




//               Iterable (Interface)
//                    |
//               Collection (Interface)
//       _____________|_______________
//      |             |               |
//    List           Set             Queue
//     |              |                |
// ArrayList     HashSet           PriorityQueue
// LinkedList    LinkedHashSet     ArrayDeque
// Vector        TreeSet

// Map (separate hierarchy)
//  |
// HashMap
// LinkedHashMap
// TreeMap



import java.util.ArrayDeque;
import java.util.ArrayList;
// import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;












public class lec2_Collection_DSA {
    public static void main(String[] args){

        // 1. List Interface
        // 🔹 Ordered, allows duplicates.
        // 👉Common Implementations:
        // ArrayList
        // LinkedList
        // Vector
        // Stack

        // Arraylist<>() - Backed by dynamic array
        List<String> list = new ArrayList<>();
        list.add("Ankit");
        list.add("Raj");
        list.add("Raj"); // Allowed duplicate in List
        System.out.println("List: " + list);


        // LinkedList<>()  - Doubly linked list
        LinkedList<String> queue = new LinkedList<>();
        queue.add("One");
        queue.add("Two");
        queue.addFirst("Zero");
        System.out.println("LinkedList: " + queue);


        // Vector<>()  = thread-safe version of Arraylist 
        Vector<Integer> vec = new Vector<>();
        vec.add(10);
        vec.add(20);
        System.out.println("Vector: " + vec);


        // Stack (LIFO - Last In First Out)
        Stack<String> stack = new Stack<>();
        stack.push("Bottom");
        stack.push("Middle");
        stack.push("Top");
        System.out.println("Stack top: " + stack.pop());




        
        // 2. Set Interface
        // 🔹 Unordered, no duplicates
        // 👉 Common Implementations:
        // HashSet
        // LinkedHashSet
        // TreeSet


        // HashSet -- Backed by HashMap  --  No order guaranteed
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // Duplicate ignored
        System.out.println("HashSet: " + set);


        // LinkedHashSet --  Maintains insertion order --  Slightly slower than HashSet
        Set<String> lhs = new LinkedHashSet<>();
        lhs.add("C");
        lhs.add("Java");
        lhs.add("Python");
        System.out.println("LinkedHashSet: " + lhs);


        // TreeSet -- Stores in sorted (Natual or custom) order -- Backed by a Red-Black Tree
        Set<Integer> tree = new TreeSet<>();
        tree.add(30);
        tree.add(10);
        tree.add(20);

        System.out.println("TreeSet: " + tree);



        // 3. Queue Interface
        // 🔹 FIFO – First In First Out
        // 👉 Common Implementations:
        // LinkedList
        // PriorityQueue
        // ArrayDeque


        // LinkedList<>()  -- Implementing a basic queue 
        Queue<String> queue2 = new LinkedList<>();
        queue2.add("First");
        queue2.add("Second");
        System.out.println("Head: " + queue2.poll());


        // PriorityQueue -- Elements sorted by natural or custom order
        // -- Default : min-heap 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);
        System.out.println("PriorityQueue top: " + pq.peek());


        // ArrayDeque -- Faster than Stack/linkedlist for deque -- can be used as stack or queue  
        // functionality - Need stack + queue functionality
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("First");
        deque.addFirst("Second");
        deque.addFirst("Third");
        deque.addLast("Last");

        System.out.println("Deque: " + deque);






        // 4. Map<K, V> Interface
        // 🔹 Key-Value pair (not part of Collection hierarchy)
        // 👉 Common Implementations:
        // HashMap
        // LinkedHashMap
        // TreeMap
        // Hashtable


        // HashMap --  Fastest non-sorted map  ---   
        // One null key, many null values
        Map<String, Integer> map = new HashMap<>();
        map.put("Ankit", 101);
        map.put("Raj", 102);
        map.put("Ankit", 103); // Overwrites value
        System.out.println("HashMap: " + map);



       // linkedHashMap -- Maintains insertion order 
        Map<String, String> map2 = new LinkedHashMap<>();
        map2.put("One", "1");
        map2.put("Two", "2");
        System.out.println("LinkedHashMap: " + map2);


        // TreeMap -- Sorted by keys -- No null keys allowed 
        // functionality -- sorted key-value pairs
        TreeMap<Integer, String> map3 = new TreeMap<>();
        map3.put(3, "Three");
        map3.put(1, "One");
        map3.put(2, "Two");

        System.out.println("TreeMap: " + map3);


        // Hashtable (Legacy , synchronized) 
        //  thread-safe map
        Hashtable<String, String> table = new Hashtable<>();
        table.put("Name", "Ankit");
        table.put("Dept", "IT");
        System.out.println("Hashtable: " + table);


       
        
    }
    
}



// Summary Table 

// | Interface | Class         | Ordered   | Sorted   | Duplicate?   | Thread-Safe  | Null Allowed  |
// | --------- | ------------- | --------  | ------   | ----------   | -----------  | ------------  |
// | List      | ArrayList     | ✅        | ❌      | ✅          | ❌           | ✅            |
// | List      | LinkedList    | ✅        | ❌      | ✅          | ❌           | ✅            |
// | List      | Vector        | ✅        | ❌      | ✅          | ✅           | ✅            |
// | List      | Stack         | ✅ (LIFO) | ❌      | ✅          | ✅           | ✅            |
// | Set       | HashSet       | ❌        | ❌      | ❌          | ❌           | 1 null         |
// | Set       | LinkedHashSet | ✅        | ❌      | ❌          | ❌           | 1 null         |
// | Set       | TreeSet       | ✅        | ✅      | ❌          | ❌           | ❌            |
// | Queue     | LinkedList    | ✅        | ❌      | ✅          | ❌           | ✅            |
// | Queue     | PriorityQueue | ❌        | ✅      | ✅          | ❌           | 1 null         |
// | Queue     | ArrayDeque    | ✅        | ❌      | ✅          | ❌           | ❌            |
// | Map       | HashMap       | ❌        | ❌      | ❌ (keys)   | ❌           | 1 null key     |
// | Map       | LinkedHashMap | ✅        | ❌      | ❌          | ❌           | 1 null key     |
// | Map       | TreeMap       | ✅        | ✅      | ❌          | ❌           | ❌            |
// | Map       | Hashtable     | ❌        | ❌      | ❌          | ✅           | ❌            |

