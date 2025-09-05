


/*

🔹 1. What is Stack Memory in Java?
    - Stack memory is where method calls and local variables are stored.
    - Every time you call a method, a new frame (block) is created on the stack.
    - When the method finishes, its frame is removed (LIFO – Last In, First Out).
    - Very fast because it’s automatically managed by JVM.
    - Only references (addresses) to objects are stored here, not the actual object.

 */

import java.lang.reflect.Method;

class StackExample {
    public static void main(String[] args) {
        int x = 10;  // stored in stack
        int y = 20;  // stored in stack
    }
}

// Both x and y (primitives) are in stack memory.



/*
🔹 2. What is Heap Memory in Java?
    - Heap memory is where all objects are stored.
    - Whenever you use new, the object is created in the heap.
    - Garbage Collector (GC) cleans unused objects from heap.
    - Heap is shared across all threads.
 */

class HeapExample {
    public static void main(String[] args) {
        String s = new String("Hello"); // Object in heap
    }
}

// "Hello" object created using new goes to heap.
// Reference s lives in stack, pointing to heap.




class Person {
    String name;
    Person(String name) { this.name = name; }
}

class MemoryExample {
    public static void main(String[] args) {
        int a = 5;                        // primitive -> stack
        Person p1 = new Person("Ankit");  // object -> heap
        Person p2 = p1;                   // reference copy -> stack
    }
}



// 4. Key difference Between Stack and Heap 
/* 

| Feature          | Stack                               | Heap                            |
| ---------------- | ----------------------------------- | ------------------------------- |
| **Storage**      | Method calls, local variables, refs | All objects, instance variables |
| **Size**         | Small                               | Large                           |
| **Access Speed** | Very fast                           | Slower than stack               |
| **Thread**       | Each thread has its own stack       | Shared among all threads        |
| **Lifetime**     | Exists until method ends            | Exists until GC removes it      |
| **Managed By**   | JVM automatically                   | JVM + Garbage Collector         |

*/


public class lec14_stack_vs_heap {
    
}

/*

✅ Summary
    - Stack: Stores method calls, local variables, and object references. Very fast.
    - Heap: Stores objects and instance variables. Shared across threads. Slower, but bigger.
    - Primitives → stored in stack.
    - Objects → stored in heap, with their references in stack.
    
 */
