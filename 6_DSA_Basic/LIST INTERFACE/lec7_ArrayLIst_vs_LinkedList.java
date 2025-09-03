




// Difference between arraylist and Linkedlist 

// | Feature                                  | **ArrayList**                                                                  | **LinkedList**                                                                       |
// | ---------------------------------------- | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
// | **Underlying Data Structure**            | Uses **dynamic array** internally.                                             | Uses a **doubly linked list** internally.                                            |
// | **Access (get/set by index)**            | **Fast (O(1))**, because it uses array indexing.                               | **Slow (O(n))**, must traverse from the head or tail to the index.                   |
// | **Insertion/Deletion (at end)**          | **Fast (Amortized O(1))**, unless array needs resizing.                        | **Fast (O(1))**, just adjust pointers.                                               |
// | **Insertion/Deletion (at middle/start)** | **Slow (O(n))**, because elements need to be shifted.                          | **Faster (O(1))** if position is known (via iterator); but finding position is O(n). |
// | **Memory usage**                         | Less memory (only data + small overhead).                                      | More memory (stores data + two pointers for each node).                              |
// | **Iteration**                            | Better **cache locality**, so iteration is generally **faster**.               | Iteration is **slower** because nodes are scattered in memory.                       |
// | **When resizing is needed**              | If array is full, a **new array is created and elements are copied** → costly. | No resizing needed; nodes are dynamically allocated.                                 |



/*
 * When to use what?
Use ArrayList if:
    - You need fast random access (get by index).
    - Most operations are read-heavy.
    - Insertions/deletions happen mostly at the end.

Use LinkedList if:
    - You need fast insertions/deletions in the middle/start.
    - You don’t need frequent random access.
    - Memory overhead isn’t a big concern.
 */

public class lec7_ArrayLIst_vs_LinkedList {
    
}
