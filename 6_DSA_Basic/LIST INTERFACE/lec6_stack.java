
// Stack in Java – Overview
// In Java, Stack is a class that implements the List interface through Vector, which is a legacy class.

// Stack<E> extends Vector<E> implements List<E>

// So technically:
// Stack is a subclass of Vector
// Vector implements the List interface
// Therefore, Stack inherits all List methods.

// ⚠️ Stack is synchronized (thread-safe), but it's considered legacy. import java.util.Stack;


// In Java Collections, the term Legacy classes refers to the original collection classes that were part of Java 1.0, before the Java Collections Framework (JCF) was introduced in Java 1.2.


// IN STACK 
// Internally:
// It uses an array-based structure inherited from Vector.
// Methods like push(), pop() are built on top of array operations like add() and remove().

import java.util.Stack;

public class lec6_stack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Push elements
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack after pushes: " + stack);

        // Peek at top
        System.out.println("Peek: " + stack.peek()); // C

        // Pop element
        System.out.println("Pop: " + stack.pop());   // C

        // Search element (1-based index from top)
        System.out.println("Position of B: " + stack.search("B")); // 1

        // Check empty
        System.out.println("Is empty? " + stack.empty()); // false

        // Use List interface method - get
        System.out.println("Element at index 0: " + stack.get(0)); // A

        // Use set (List method)
        stack.set(0, "Z");
        System.out.println("After set(0, Z): " + stack);

        // Size
        System.out.println("Size: " + stack.size()); // 2

        // Loop through stack
        for (String s : stack) {
            System.out.println("Element: " + s);
        }
    }
}


// Key Methods of Stack 
// | Method         | Description                       | Time Complexity |
// | -------------- | --------------------------------- | --------------- |
// | `push(E item)` | Adds item to top of stack         | O(1)            |
// | `pop()`        | Removes and returns top item      | O(1)            |
// | `peek()`       | Returns top item without removing | O(1)            |
// | `empty()`      | Returns true if stack is empty    | O(1)            |
// | `search(E o)`  | Returns 1-based position from top | O(n)            |
// | `size()`       | Returns number of elements        | O(1)            |
// | `get(index)`   | Gets element at specific index    | O(1)            |
// | `set(index,e)` | Updates element at index          | O(1)            |




// Summary
// Stack is built on top of Vector which implements List.
// It supports all List methods plus push, pop, peek, etc.
// Most operations are O(1), except search.
// Avoid using Stack in new code — prefer Deque (ArrayDeque) unless you must use legacy code.




// NOTE : 
// Stack is synchronized (thread-safe), but it's considered legacy. For modern code, Deque (via ArrayDeque) is recommended.
