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

- **Major operations:**
    - Creation of AVL trees
    - Search for a node in AVL trees
    - Traverse all nodes in AVL trees
    - Insert a node in AVL Trees
    - Delete a node from AVL trees
    - Delete the entire AVL trees

---



# 🌳 AVL Tree Imbalances & Rotations

An AVL tree rebalances itself when the Balance Factor (BF) of a node goes outside the range [-1, 1].

**Balance Factor (BF) = Height(left subtree) – Height(right subtree)**

- If BF > 1 → Left Heavy
- If BF < -1 → Right Heavy

Depending on where the new node is inserted, one of the 4 imbalance cases occurs:

---

## 1. Left-Left (LL) Case

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

