# Binary Heap in Java

## 1. Definition

A **Binary Heap** is a complete binary tree that satisfies the heap property:

- **Max-Heap:** Every parent node is greater than or equal to its child nodes.
- **Min-Heap:** Every parent node is less than or equal to its child nodes.

A binary heap is **complete**, meaning all levels are fully filled except possibly the last, which is filled from left to right.

---

## 2. Properties of Binary Heap

- **Shape Property:** Complete binary tree.
- **Heap Property:**
    - Max-Heap: parent ≥ children
    - Min-Heap: parent ≤ children
- **Array Representation:**
    - For node at index `i`:
        - Left child → `2*i + 1`
        - Right child → `2*i + 2`
        - Parent → `(i - 1) / 2`

---

## 3. Types of Binary Heap

| Type      | Description         | Root Node Relation to Children      |
|-----------|---------------------|------------------------------------|
| Max-Heap  | Parent ≥ Children   | Maximum element at root            |
| Min-Heap  | Parent ≤ Children   | Minimum element at root            |

---

## 4. Why Do We Need Binary Heaps?

A Binary Heap is mainly needed for efficient priority management:

- **Fast Access to Maximum/Minimum:**
    - Max-Heap → quickly get maximum element
    - Min-Heap → quickly get minimum element
    - Useful for priority queues.
- **Efficient Insertion and Deletion:**
    - Both insertion and deletion of root take O(log n) time.
    - Sorted arrays take O(n) for insertion/deletion at correct position.
- **Memory Efficiency:**
    - Represented as an array → no need for pointers like in trees.

---

## 5. Applications

- Priority queues
- Heap Sort
- Graph algorithms (Dijkstra, Prim)
- Task scheduling (CPU job scheduling)
- Event simulation

---

## 6. Binary Heap Diagram

**Max-Heap Example:**
```
      50
     /  \
   40    20
  /  \   /
30  10  15
```
- Each parent is greater than its children.

---

## 7. Operations and Complexities

| Operation                   | Description                                                  | Time Complexity | Space Complexity |
|-----------------------------|-------------------------------------------------------------|-----------------|------------------|
| Insert (push)               | Add new element at end, then `heapifyUp`                    | O(log n)        | O(1)             |
| Get Min / Max (peek)        | Return root element                                         | O(1)            | O(1)             |
| Extract Min / Max (pop)     | Remove root, replace with last, then `heapifyDown`          | O(log n)        | O(1)             |
| Delete (at index i)         | Replace element with last, then `heapifyUp` or `heapifyDown`| O(log n)        | O(1)             |
| Heapify (on node i)         | Fix heap property at subtree rooted at `i`                  | O(log n)        | O(1)             |
| Build Heap (from array)     | Call `heapifyDown` on all non-leaf nodes                    | O(n)            | O(1)             |
| Search element              | Check one by one (no ordering guarantee)                    | O(n)            | O(1)             |
| Heap Sort                   | Build heap + repeatedly extract                             | O(n log n)      | O(1) (in-place)  |

---

## 8. Array Representation

- Heap is stored in an array.
- For node at index `i`:
    - Left child: `2*i + 1`
    - Right child: `2*i + 2`
    - Parent: `(i - 1) / 2`

---

## 9. Binary Heap Implementation (Max-Heap)

**Key Methods:**
- `insert(val)`: Add element and maintain heap property.
- `extractMax()`: Remove and return root (max element).
- `delete(index)`: Remove element at index.
- `buildHeap(arr)`: Build heap from array.
- `peek()`: Return root element.
- `printHeap()`: Print heap array.
- `size()`: Return heap size.
- `isEmpty()`: Check if heap is empty.

**Sample Implementation (Java):**
```java
class BinaryHeap {
    private ArrayList<Integer> heap;

    public BinaryHeap() { heap = new ArrayList<>(); }

    int parent(int i) { return (i-1)/2; }
    int leftChild(int i) { return 2*i + 1; }
    int rightChild(int i) { return 2*i + 2; }

    void insert(int val) {
        heap.add(val);
        int index = heap.size() - 1;
        heapifyUp(index);
    }

    void heapifyUp(int index) {
        while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    int extractMax() {
        if (heap.isEmpty()) return -1;
        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return root;
    }

    void heapifyDown(int index) {
        int size = heap.size();
        while (true) {
            int largest = index;
            int left = leftChild(index);
            int right = rightChild(index);
            if (left < size && heap.get(left) > heap.get(largest)) largest = left;
            if (right < size && heap.get(right) > heap.get(largest)) largest = right;
            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else break;
        }
    }

    void delete(int index) {
        if (index >= heap.size()) return;
        int last = heap.remove(heap.size() - 1);
        if (index < heap.size()) {
            heap.set(index, last);
            heapifyDown(index);
            heapifyUp(index);
        }
    }

    void buildHeap(int[] arr) {
        heap.clear();
        for (int val : arr) heap.add(val);
        int n = heap.size();
        for (int i = n/2 - 1; i >= 0; i--) heapifyDown(i);
    }

    public int peek() { return heap.isEmpty() ? -1 : heap.get(0); }
    public void printHeap() { System.out.println(heap); }
    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }
}
```

**Usage Example:**
```java
BinaryHeap heap = new BinaryHeap();
heap.insert(50);
heap.insert(30);
heap.insert(20);
heap.insert(40);
heap.insert(10);
heap.printHeap(); // [50, 40, 20, 30, 10]
System.out.println(heap.extractMax()); // 50
heap.printHeap(); // [40, 30, 20, 10]
heap.delete(1); // delete element at index 1
heap.printHeap(); // [40, 10, 20]
int[] arr = {3, 5, 9, 6, 8, 20};
heap.buildHeap(arr);
heap.printHeap(); // [20, 8, 9, 6, 5, 3]
System.out.println(heap.peek()); // 20
```

---

## 10. Notes

- Binary Heap is efficient for priority queue operations.
- All operations maintain O(log n) time except peek/search.
- Array-based implementation is memory efficient.
- Heap sort uses binary heap for in-place sorting.

---
