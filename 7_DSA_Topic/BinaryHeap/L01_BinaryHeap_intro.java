/*
Binary Heap in Java

1. Definition
A Binary Heap is a complete binary tree that satisfies the heap property:
- Max-Heap: Every parent node is greater than or equal to its child nodes.
- Min-Heap: Every parent node is less than or equal to its child nodes.
A binary heap is complete, meaning all levels are fully filled except possibly the last level, which is filled from left to right.

2. Properties of Binary Heap
- Shape Property: Complete binary tree.
- Heap Property:
    Max-Heap: parent >= children
    Min-Heap: parent <= children
- Representation: Usually implemented using an array:
    For node at index i:
        Left child → 2*i + 1
        Right child → 2*i + 2
        Parent → (i - 1) / 2

3. Types of Binary Heap
Type      | Description         | Root Node Relation to Children
Max-Heap  | Parent ≥ Children   | Maximum element at root
Min-Heap  | Parent ≤ Children   | Minimum element at root

Why Do We Need Binary Heaps?
A Binary Heap is mainly needed for efficient priority management:
- Fast Access to Maximum/Minimum:
    Max-Heap → quickly get maximum element
    Min-Heap → quickly get minimum element
    Useful for priority queues.
- Efficient Insertion and Deletion:
    Both insertion and deletion of root take O(log n) time.
    Sorted arrays take O(n) for insertion/deletion at correct position.
- Memory Efficiency:
    Represented as an array → no need for pointers like in trees.

Applications:
- Priority queues
- Heap Sort
- Graph algorithms (Dijkstra, Prim)
- Task scheduling (CPU job scheduling)
- Event simulation

| Operation                   | Description                                                  | Time Complexity | Space Complexity |
| --------------------------- | ------------------------------------------------------------ | --------------- | ---------------- |
| Insert (push)               | Add new element at end, then heapifyUp                      | O(log n)        | O(1)             |
| Get Min / Max (peek)        | Return root element                                         | O(1)            | O(1)             |
| Extract Min / Max (pop)     | Remove root, replace with last, then heapifyDown            | O(log n)        | O(1)             |
| Delete (at index i)         | Replace element with last, then heapifyUp or heapifyDown    | O(log n)        | O(1)             |
| Heapify (on node i)         | Fix heap property at subtree rooted at i                    | O(log n)        | O(1)             |
| Build Heap (from array)     | Call heapifyDown on all non-leaf nodes                      | O(n)            | O(1)             |
| Search element              | Check one by one (no ordering guarantee)                    | O(n)            | O(1)             |
| Heap Sort                   | Build heap + repeatedly extract                             | O(n log n)      | O(1) (in-place)  |
*/

public class L01_BinaryHeap_intro {
    
}
