

// stack vs Heap memory ; 

// Java Memory Model Overview
// Java memory is primarily divided into two main areas:
// | Memory Type  | Stores                            | Managed by           |
// | ------------ | --------------------------------- | -------------------- |
// | 🧮 **Stack** | Method calls, local variables     | Automatically by JVM |
// | 🗃️ **Heap** | Objects, instance variables (new) | Garbage Collector    |




// 1. Stack Memory
// 🔹 What is Stack Memory?
// It stores method call frames, primitive data types, and references to objects.
// Each thread has its own stack.
// LIFO (Last In First Out) structure.

// Memory is automatically allocated and deallocated.
// 🔹 What goes on the stack?
// Local variables inside a method
// Method parameters
// Method call order (for recursion or nested calls)

// ✅ Pros:
// Fast access
// Automatically cleared after method execution





//  2. Heap Memory
// 🔹 What is Heap Memory?
// Used for storing objects and instance variables.
// Shared among all threads.
// Managed by Garbage Collector (GC).

// 🔹 What goes on the heap?
// Any object created with new
// Instance variables of objects

// Pros:
// Objects live as long as needed (until GC)
// Large storage area




// Stack                                Heap
// -------------------------------------------------------
// main() frame                         Person object
//   p  ─────────────┐                ┌──────────────────────┐
//                   │──────────────►│ name --> "Ankit"      │
//                                    │ age  = 23             │
//                                    └──────────────────────┘

// "Ankit" (String pool in heap)

// MOTE : 
// Method parameters like int age = 23 ⇒ stack (temporary)
// Object fields like this.age = 23 ⇒ heap



class Person{
    String name ; 
    int age ; 

    Person(String name , int age){
        this.name = name ; 
        this.age = age ; 
    }
}

public class lec1_stack_heap_memory{

    public static int add(int a , int b){
        int result = a + b ; // all local vars in stack 
        return result ; 
    }

    public static void main(String[] args){
        int x = 10 ;  // stored in stack 
        int y = 20 ;  // stored in stack 
        int sum = add(x , y) ;  // method call on stack 


        Person p  = new Person("Ankit" , 23) ; // object p in heap 
        // p is a reference stored in stack but the actual person object is in heap . 

        System.out.println(sum + " " + p) ; 
    }
}


// Key Points:
// Stack is for method-level memory
// Heap is for object-level memory
// GC only clears heap, not stack
// Stack Overflow occurs if too many recursive calls (stack memory full)