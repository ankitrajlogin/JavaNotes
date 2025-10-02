# AVL Tree

**Diagram of a Balanced AVL Tree:**
```
      30
     /  \
   20    40
  /  \     \
10  25     50
```
- Each node's left and right subtree heights differ by at most 1.

## What is an AVL Tree?

- An AVL Tree is a self-balancing binary search tree where the difference between the heights of the left and right subtrees of any node (known as the balance factor) is at most 1. This ensures that the tree remains approximately balanced, which guarantees O(log n) time complexity for search, insertion, and deletion operations.

### 1. Key Properties
- It follows all rules of a BST:
    - Left child < Parent
    - Right child > Parent

- Balance Factor (BF):
    - For every node:
        BF = Height of Left Subtree − Height of Right Subtree
    - In AVL trees, the balance factor must always be -1, 0, or +1.
    - If it goes outside this range (like -2 or +2), rotations are performed to rebalance.

- Height of AVL Tree is always O(log n).
    - This ensures faster searching, insertion, and deletion compared to normal BST.

### 2. Key Characteristics of an AVL Tree
- Each node stores a height value, which is used to calculate the balance factor.
- Rotations (left, right, left-right, right-left) are performed to restore balance whenever the balance factor of a node becomes greater than 1 or less than -1.
- The tree is named after its inventors, Adelson-Velsky and Landis.

### 3. Advantages
- Ensures faster lookups, insertions, and deletions compared to unbalanced binary search trees.

### 4. Use Cases
- Suitable for applications where frequent insertions and deletions occur, and maintaining a balanced tree is critical for performance.

#### Real-life Uses
- Databases (to keep indexes balanced)
- File systems
- Memory management
- Routing tables in networks

---

## Operations

- **Insertion**
    - Insert like a normal BST.
    - Check balance factor → if unbalanced, apply rotations.

- **Deletion**
    - Delete like a normal BST.
    - Re-check balance factor and perform rotations if required.

- **Rotations (to restore balance):**
    - Right Rotation (LL Rotation)
    - Left Rotation (RR Rotation)
    - Left-Right Rotation (LR Rotation)
    - Right-Left Rotation (RL Rotation)

- **Time Complexities**
    - Search → O(log n)
    - Insertion → O(log n)
    - Deletion → O(log n)
    - (because height of AVL tree is always log n)

---

## ⏱️ Time Complexity of AVL Tree Functions

| Operation                | Time Complexity |
|--------------------------|----------------|
| Create AVL Tree          | O(n log n)     |
| Search for a node        | O(log n)       |
| Traverse all nodes       | O(n)           |
| Insert a node            | O(log n)       |
| Delete a node            | O(log n)       |
| Delete entire AVL tree   | O(n)           |

- **Create AVL Tree:** O(n log n) if inserting n nodes one by one.
- **Search:** O(log n) due to balanced height.
- **Traverse:** O(n) for inorder/preorder/postorder traversal.
- **Insert/Delete:** O(log n) (includes possible rotations).
- **Delete entire tree:** O(n) (visit every node).

---

## 📊 Detailed Time Complexity Analysis of AVL Tree Operations

1. **Height of AVL Tree**
    - For n nodes, height h = O(log n)
    - Worst-case height: h ≤ 1.44 * log₂(n + 2) - 0.328
    - Rotations keep the tree balanced.

2. **Search**
    - Works like BST: go left/right based on comparison.
    - Best case: O(1) (found at root)
    - Average/Worst case: O(log n) (height of tree)
    - Reason: AVL tree height is O(log n), so max comparisons = O(log n)

3. **Insertion**
    - Insert like BST: O(log n)
    - Update heights: O(1) per node, total O(log n)
    - Rebalance (rotations): Single/Double rotation = O(1)
    - **Total Time Complexity:** O(log n)
    - Rotations are constant-time and only performed along the path to root.

4. **Deletion**
    - Delete like BST: O(log n)
    - Update heights: O(log n)
    - Rebalance (rotations): O(log n) worst case (may need multiple rotations up the tree)
    - **Total Time Complexity:** O(log n)
    - Deletion may require multiple rotations up to root.

5. **Find Minimum / Maximum**
    - Go all the way to left (min) or right (max)
    - **Time Complexity:** O(log n)

6. **Traversals (Inorder, Preorder, Postorder)**
    - Visits every node once
    - **Time Complexity:** O(n)
    - **Space Complexity:** O(h) = O(log n) for recursion stack

7. **Rotations (LL, RR, LR, RL)**
    - Each rotation: O(1)
    - Only affects a few nodes locally.

8. **Delete Entire Tree**
    - Post-order traversal to delete nodes
    - **Time Complexity:** O(n)
    - **Space Complexity:** O(h) = O(log n)

9. **Summary Table**

| Operation      | Time Complexity | Reason                                      |
|----------------|----------------|---------------------------------------------|
| Search         | O(log n)       | Height of AVL tree ≤ log n                  |
| Insert         | O(log n)       | Path + rotation along path ≤ log n          |
| Delete         | O(log n)       | Path + possible rotations ≤ log n           |
| Find Min/Max   | O(log n)       | Go left/right to leaf                       |
| Traversals     | O(n)           | Visit every node                            |
| Rotations      | O(1)           | Constant time adjustments                   |
| Delete Entire  | O(n)           | Visit each node once                        |

---

## 🧮 Space Complexity Analysis

- **Search / Insertion / Deletion**
    - Iterative: O(1) extra space.
    - Recursive: O(h) = O(log n) stack space (h = tree height).
- **Find Min / Max**
    - Iterative: O(1)
    - Recursive: O(h)
- **Rotations**
    - O(1) (only pointer changes)
- **Traversals (Inorder, Preorder, Postorder)**
    - O(h) = O(log n) for recursion stack.
- **Delete Entire Tree**
    - O(h) = O(log n) for recursion stack (post-order traversal).

---

## 📋 Why These Complexities Hold

- **Search / Insertion / Deletion:**  
  AVL tree height is always O(log n), so traversing from root to leaf takes O(log n) steps.  
  Rotations are constant time, only a few nodes change pointers.

- **Traversal:**  
  Every node is visited once, so O(n) time.  
  Recursive stack goes up to height h = O(log n).

- **Space Complexity:**  
  Iterative methods: O(1) extra space.  
  Recursive methods: O(h) = O(log n) stack space.

- **Delete Entire Tree:**  
  Uses post-order traversal.  
  Visits all nodes → O(n) time.  
  Recursive stack height → O(h) = O(log n).

---

## 📝 Summary Table for AVL Tree Operations

| Operation                | Time Complexity | Space Complexity      |
|--------------------------|----------------|----------------------|
| Search                   | O(log n)       | O(1) / O(log n)      |
| Insert                   | O(log n)       | O(1) / O(log n)      |
| Delete                   | O(log n)       | O(1) / O(log n)      |
| Min / Max                | O(log n)       | O(1) / O(log n)      |
| Rotations                | O(1)           | O(1)                 |
| Traversals (In/Pre/Post) | O(n)           | O(log n)             |
| Delete Entire Tree       | O(n)           | O(log n)             |

---

# 🌳 AVL Tree Imbalances & Rotations

An AVL tree rebalances itself when the Balance Factor (BF) of a node goes outside the range [-1, 1].

**Balance Factor (BF) = Height(left subtree) – Height(right subtree)**

- If BF > 1 → Left Heavy
- If BF < -1 → Right Heavy

Depending on where the new node is inserted, one of the 4 imbalance cases occurs:

---

## 1. Left-Left (LL) Case

**AVL Tree Example Diagram:**
```
    30
   /  \
  20   40
 /  \
10  25
```

**When?**
- BF > 1 (left heavy)
- Node inserted into the left child’s left subtree.

👉 **Fix with Right Rotation**

**Simple Example:** Insert 10, 20, 30

**Before:**
```
    30
   /
  20
 /
10
```

**After Right Rotation:**
```
   20
  /  \
 10   30
```

**With Subtrees:**
```
        z
       / \
      y   T4
     / \
    x   T3
   / \
  T1  T2
```

Insertion makes left subtree too heavy.

**After Right Rotation (on z):**
```
        y
       / \
      x   z
     / \ / \
    T1 T2 T3 T4
```

✅ Tree balanced.

---

## 2. Right-Right (RR) Case

**When?**
- BF < -1 (right heavy)
- Node inserted into the right child’s right subtree.

👉 **Fix with Left Rotation**

**Simple Example:** Insert 10, 20, 30

**Before:**
```
  10
    \
     20
       \
        30
```

**After Left Rotation:**
```
    20
   /  \
  10   30
```

**With Subtrees:**
```
    z
   / \
  T1  y
     / \
    T2  x
       / \
      T3  T4
```

**After Left Rotation (on z):**
```
        y
       / \
      z   x
     / \ / \
    T1 T2 T3 T4
```

✅ Tree balanced.

---

## 3. Left-Right (LR) Case

**When?**
- BF > 1 (left heavy)
- Node inserted into the left child’s right subtree.

👉 **Fix with Double Rotation:** Left Rotation (on left child) + Right Rotation (on root)

**Simple Example:** Insert 30, 10, 20

**Before:**
```
    30
   /
  10
    \
     20
```

**Step 1: Left Rotate at 10**
```
    30
   /
  20
 /
10
```

**Step 2: Right Rotate at 30**
```
    20
   /  \
  10   30
```

**With Subtrees:**
```
        z
       / \
      y   T4
     / \
    T1  x
       / \
      T2  T3
```

**Step 1: Left Rotation (on y)**
```
        z
       / \
      x   T4
     / \
    y   T3
   / \
  T1  T2
```

**Step 2: Right Rotation (on z)**
```
        x
       / \
      y   z
     / \ / \
    T1 T2 T3 T4
```

✅ Tree balanced.

---

## 4. Right-Left (RL) Case

**When?**
- BF < -1 (right heavy)
- Node inserted into the right child’s left subtree.

👉 **Fix with Double Rotation:** Right Rotation (on right child) + Left Rotation (on root)

**Simple Example:** Insert 10, 30, 20

**Before:**
```
   10
     \
      30
     /
    20
```

**Step 1: Right Rotate at 30**
```
   10
     \
      20
        \
         30
```

**Step 2: Left Rotate at 10**
```
    20
   /  \
  10   30
```

**With Subtrees:**
```
    z
   / \
  T1  y
     / \
    x   T4
   / \
  T2  T3
```

**Step 1: Right Rotation (on y)**
```
    z
     \
      x
       \
        y
```

**With Subtrees:**
```
    z
   / \
  T1  x
     / \
    T2  y
       / \
      T3  T4
```

**Step 2: Left Rotation (on z)**
```
        x
       / \
      z   y
     / \ / \
    T1 T2 T3 T4
```

✅ Tree balanced.

---

## Example AVL Tree Diagram

A typical balanced AVL tree looks like:

```
      30
     /  \
   20    40
  /  \     \
10  25     50
```

- The difference in height between left and right subtree of every node is at most 1.

---

## ✅ Quick Rotation Guide

| Case | Condition | Rotation Needed |
|------|-----------|----------------|
| LL   | BF > 1 and new node in left-left | Right Rotation |
| RR   | BF < -1 and new node in right-right | Left Rotation |
| LR   | BF > 1 and new node in left-right | Left Rotation on child + Right Rotation on root |
| RL   | BF < -1 and new node in right-left | Right Rotation on child + Left Rotation on root |

🔥 **So basically:**
- If imbalance is straight line (LL or RR) → Single rotation.
- If imbalance is zig-zag (LR or RL) → Double rotation.

---

## 🔑 Summary of Imbalances

| Case | Imbalance    | Rotation Needed                |
|------|--------------|-------------------------------|
| LL   | Left-Left    | Single Right Rotation         |
| RR   | Right-Right  | Single Left Rotation          |
| LR   | Left-Right   | Left Rotation + Right Rotation|
| RL   | Right-Left   | Right Rotation + Left Rotation|

---

