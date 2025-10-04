# Segment Tree – Complete Notes

## 1. Introduction

A **Segment Tree** is a binary tree data structure used to efficiently store information about intervals or segments.  
It allows performing range queries (sum, min, max, gcd, etc.) and updates on an array in **O(log n)** time.

- **Without segment tree:**  
  - Range queries (sum/min/max): O(n) per query  
  - Updates: O(1)
- **With segment tree:**  
  - Range queries: O(log n)  
  - Updates: O(log n)

---

## 2. Important Definitions

- **Segment / Interval:** A continuous part of an array, e.g. [2, 5].
- **Range Query:** Query about a function (sum, min, max, gcd) on a segment of an array.
- **Point Update:** Updating a single element in the array.
- **Range Update:** Updating multiple elements in a segment.
- **Lazy Propagation:** Optimization for efficient range updates.

---

## 3. Structure of Segment Tree

- A binary tree, usually represented as an array.
- **Root** represents the entire array [0, n-1].
- **Internal nodes** represent subranges [l, r].
- **Leaf nodes** represent a single element [i, i].

**Size Formula:**  
For an array of size n, the segment tree requires at most:  
`Size ≤ 2 * 2^ceil(log2(n)) - 1 ≤ 4n`

---

## 4. Example

Suppose we have an array:  
`A = [2, 5, 1, 4, 9, 3]`

We want to build a Segment Tree for **Range Sum** queries.

**Segment Tree Diagram (Range Sum):**
```
                         [0-5] (24)
                      /               \
             [0-2] (8)                 [3-5] (16)
            /       \                 /         \
     [0-1] (7)     [2-2] (1)    [3-4] (13)    [5-5] (3)
     /     \                     /      \
 [0-0](2) [1-1](5)         [3-3](4) [4-4](9)
```
- Root [0-5] stores total sum = 24
- Each node stores sum of its range
- Leaf nodes store actual elements

---

## 5. Operations on Segment Tree

### (A) Building the Tree

Recursively divide the array into two halves.

**Time Complexity:** O(n)

**Pseudo-code:**
```java
void build(int node, int start, int end) {
    if(start == end) {
        tree[node] = arr[start];  // leaf node
    } else {
        int mid = (start + end) / 2;
        build(2*node, start, mid);
        build(2*node+1, mid+1, end);
        tree[node] = tree[2*node] + tree[2*node+1];  // sum example
    }
}
```

### (B) Range Query (e.g., Sum in [l, r])

- If range fully inside → return node value
- If outside → return 0 (for sum)
- Else → query both children

**Time Complexity:** O(log n)

### (C) Point Update

Update value at index i and propagate changes up.

**Time Complexity:** O(log n)

### (D) Lazy Propagation (for Range Updates)

Used when updating a large range frequently.  
Instead of updating immediately, store a "lazy value" at the node and push it down later when needed.

**Time Complexity:** O(log n)

---

## 6. Applications (Use Cases)

- Range Sum Queries (faster than prefix sums for updates)
- Range Minimum/Maximum Queries
- Range GCD / LCM Queries
- Interval Problems (overlaps, scheduling)
- Competitive Programming:
    - Dynamic array queries
    - Histogram problems
    - String processing (longest prefix, etc.)

---

## 7. Advantages

- Efficient (logarithmic queries & updates)
- Flexible (supports many types of range queries)

## 8. Disadvantages

- Uses extra memory (up to 4n)
- More complex implementation compared to Fenwick Tree (BIT)

---

## 9. Final Formula

**Total Nodes in Segment Tree for array of size n:**  
`Nodes(n) = 2 * 2^ceil(log2(n)) - 1`

---

## 10. Notes

- The bound is strict: `Nodes(n) ≤ 4n - 1`
- You will never actually fill all 4n entries; 4n is chosen for implementation simplicity and safety.
- Both `ceil(log2(n))` and `floor(log2(n)) + 1` forms are equivalent for this calculation.

---

## 11. Java Implementation (Sum Segment Tree)

```java
class SegmentTree {
    int[] tree, arr;
    int n;

    SegmentTree(int[] input) {
        n = input.length;
        arr = input;
        tree = new int[4 * n];  // safe size
        build(1, 0, n - 1);
    }

    void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(node * 2, start, mid);
            build(node * 2 + 1, mid + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    int query(int node, int start, int end, int l, int r) {
        if (r < start || l > end) return 0; // no overlap
        if (l <= start && end <= r) return tree[node]; // full overlap
        int mid = (start + end) / 2;
        int leftSum = query(node * 2, start, mid, l, r);
        int rightSum = query(node * 2 + 1, mid + 1, end, l, r);
        return leftSum + rightSum;
    }

    void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            arr[idx] = val;
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) update(node * 2, start, mid, idx, val);
            else update(node * 2 + 1, mid + 1, end, idx, val);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }
}
```

---

## 10. Complexity Analysis

| Operation         | Time Complexity | Space Complexity |
|-------------------|----------------|------------------|
| Build Tree        | O(n)           | O(4n)            |
| Range Query       | O(log n)       | O(4n)            |
| Point Update      | O(log n)       | O(4n)            |
| Range Update (Lazy)| O(log n)      | O(4n)            |

---

## 11. Segment Tree Size & Node Formula

- For array of size n, segment tree needs at most `2 * 2^ceil(log2(n)) - 1` nodes.
- In practice, allocate array of size `4n` for safety.

**Proof:**  
Let `k = ceil(log2(n))`, so `2^(k-1) < n ≤ 2^k`.  
Total nodes = `2 * 2^k - 1 = 2^{k+1} - 1`.  
Since `2^k < 2n`, `2^{k+1} - 1 < 4n - 1 < 4n`.  
So, `Nodes(n) ≤ 4n - 1` for all n.

---

## 12. Final Summary

- Segment Tree is a binary tree for efficient range queries & updates.
- Stores information about segments in O(4n) space.
- Build: O(n), Query/Update: O(log n).
- Supports advanced operations with lazy propagation.
- Widely used in competitive programming and real-life interval problems.

---

# Segment Tree: Number of Nodes & Array Size

## 1. Segment Tree Structure

A segment tree is a complete binary tree built for an array of size `n`.  
It is used for range queries and updates in logarithmic time.

---

## 2. Number of Nodes When n is a Power of 2

If the input array size is `n = 2^k`:

- **Leaves:** `n`
- **Internal nodes:** `n - 1`
- **Total nodes:** `2n - 1`

**Example:**  
If `n = 8` (which is `2^3`),  
Total nodes = `2*8 - 1 = 15`

---

## 3. Number of Nodes When n is NOT a Power of 2

We build the tree for the next power of 2, say `m`.

- `m = 2^ceil(log2(n))` (next power of 2 ≥ n)
- **Leaves:** `m`
- **Internal nodes:** `m - 1`
- **Total nodes:** `2m - 1 = 2 * 2^ceil(log2(n)) - 1`

**Example:**  
If `n = 9`  
`ceil(log2(9)) = 4` → `m = 2^4 = 16`  
Total nodes = `2*16 - 1 = 31`

---

## 4. General Formula

For any `n`:

**Total nodes in segment tree:**  
`Nodes(n) = 2 * 2^ceil(log2(n)) - 1`

---

## 5. Why Implementation Uses 4n

Since `2^ceil(log2(n)) < 2n`,  
We get:

`Nodes(n) < 2 * (2n) - 1 = 4n - 1 < 4n`

So the segment tree is always less than `4n` nodes, which is why we allocate `4n` in practice.

---

## 5a. Proof and Derivation of the 4n-1 Bound

Let `k = ceil(log2(n))`.  
By definition of ceiling, `2^(k-1) < n ≤ 2^k`.

- The segment tree is built for `m = 2^k` leaves.
- Total nodes: `Nodes(n) = 2m - 1 = 2 * 2^k - 1 = 2^{k+1} - 1`

Now, since `n ≤ 2^k < 2n` (because `2^k` is the next power of 2 greater than or equal to n):

- Multiply both sides by 2: `2^{k+1} < 4n`
- Therefore, `Nodes(n) = 2^{k+1} - 1 < 4n - 1 < 4n`

**Conclusion:**  
The total number of nodes in a segment tree for any array of size n is always strictly less than `4n`.  
Allocating an array of size `4n` guarantees enough space for all nodes.

**Numeric Example:**  
Let `n = 9`  
`k = ceil(log2(9)) = 4`  
`m = 2^4 = 16`  
`Nodes(n) = 2*16 - 1 = 31`  
`4n = 36`  
`31 < 36` ✔️

**General Steps:**
1. Find `k = ceil(log2(n))`
2. Compute `m = 2^k`
3. Total nodes = `2m - 1 = 2^{k+1} - 1`
4. Since `2^k < 2n`, `2^{k+1} - 1 < 4n - 1`

**Therefore:**  
`Nodes(n) ≤ 4n - 1` for all n.

---

## 6. Proof: Why 4n Is Always Safe

Let `k = ceil(log2(n))`.  
By definition, `2^(k-1) < n ≤ 2^k`.

- Multiply both sides by 2: `2^k < 2n`
- Multiply by 2 again: `2^(k+1) < 4n`
- Recall: `Nodes(n) = 2^(k+1) - 1 < 4n - 1 < 4n`

Therefore, allocating an array of size `4n` always leaves some spare slots and never overflows.

---

## 7. Numeric Examples

| n  | ceil(log2(n)) | m (next power of 2) | Nodes(n) = 2m-1 | 2n | 3n | 4n | Is 4n Safe? |
|----|---------------|---------------------|-----------------|----|----|----|------------|
| 5  | 3             | 8                   | 15              | 10 | 15 | 20 | Yes        |
| 7  | 3             | 8                   | 15              | 14 | 21 | 28 | Yes        |
| 9  | 4             | 16                  | 31              | 18 | 27 | 36 | Yes        |
| 16 | 4             | 16                  | 31              | 32 | 48 | 64 | Yes        |
| 17 | 5             | 32                  | 63              | 34 | 51 | 68 | Yes        |

- **3n** sometimes fails (see n=17: 3n=51 < 63 nodes needed).
- **4n** is always safe.

---

## 8. Segment Tree Diagram (n = 9, m = 16, total nodes = 31)

```
Index:  0         1         2         3         4         5         6         7
        |---------|---------|---------|---------|---------|---------|---------|
Level:      0         1         2         3         4         5         6         7

Tree (array indices):
         0
       /   \
      1     2
     / \   / \
    3  4  5  6
   /|  |\ /| /|
 ... (leaves at indices 15-30 for m=16)
```
- The tree is built for 16 leaves (indices 15-30), even if n=9.
- Some leaves are unused if n < m.

---

## 13. Segment Tree (0-based index) – Java Implementation

**Child formulas (0-based):**
- Left child → `2 * i + 1`
- Right child → `2 * i + 2`

This is the typical 0-based indexing style (like Heap).

```java
class SegmentTree {
    int[] tree, arr;
    int n;

    // Constructor
    SegmentTree(int[] input) {
        n = input.length;
        arr = input.clone();
        tree = new int[4 * n]; // safe size
        build(0, 0, n - 1);    // root starts at index 0
    }

    // Build function
    void build(int node, int start, int end) {
        if (start == end) {
            // Leaf node
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            build(leftChild, start, mid);
            build(rightChild, mid + 1, end);

            // Example: range sum
            tree[node] = tree[leftChild] + tree[rightChild];
        }
    }

    // Query range sum [l, r]
    int query(int node, int start, int end, int l, int r) {
        if (r < start || l > end) {
            return 0; // no overlap
        }
        if (l <= start && end <= r) {
            return tree[node]; // full overlap
        }
        // partial overlap
        int mid = (start + end) / 2;
        int leftSum = query(2 * node + 1, start, mid, l, r);
        int rightSum = query(2 * node + 2, mid + 1, end, l, r);
        return leftSum + rightSum;
    }

    // Update value at index idx → new value val
    void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            arr[idx] = val;
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node + 1, start, mid, idx, val);
            } else {
                update(2 * node + 2, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    // Helper functions to make usage easier
    int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    void update(int idx, int val) {
        update(0, 0, n - 1, idx, val);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 9, 3};
        SegmentTree segTree = new SegmentTree(arr);

        System.out.println("Sum in range [1, 4]: " + segTree.query(1, 4)); // 5+1+4+9 = 19

        segTree.update(2, 10); // update arr[2] = 10
        System.out.println("Sum in range [1, 4] after update: " + segTree.query(1, 4)); // 5+10+4+9 = 28
    }
}
```

---

### What happens with 1-based index?

- Root starts at 1.
- Left child: `2 * i`
- Right child: `2 * i + 1`
- Build/query/update functions use these formulas.
- 0-based is preferred in Java for consistency with arrays and heaps.

---

## 14. How the Build Function Works (Step-by-Step)

Given:  
`arr = [2, 5, 1, 4, 9, 3]`  
Segment tree array `tree[]` is 0-based.

### Function Signature

```java
void build(int node, int start, int end)
```
- `node`: index in segment tree array for current node
- `start`, `end`: range in original array this node represents

### Leaf Node Case

```java
if (start == end) {
    tree[node] = arr[start]; // Leaf node
}
```
- If `start == end`, this node is a leaf (single element).
- Store the value directly.
- Example: `node = 3, start = 2, end = 2` → `tree[3] = arr[2] = 1`

### Internal Node Case

```java
else {
    int mid = (start + end) / 2;
    int leftChild = 2 * node + 1;
    int rightChild = 2 * node + 2;

    build(leftChild, start, mid);
    build(rightChild, mid + 1, end);

    tree[node] = tree[leftChild] + tree[rightChild]; // sum example
}
```
- Divide the range into two halves:
    - Left: `[start, mid]`
    - Right: `[mid+1, end]`
- Compute child indices:
    - Left child: `2 * node + 1`
    - Right child: `2 * node + 2`
- Recursively build children.
- Combine their values for this node.

### Step-by-Step Example

Array: `[2, 5, 1, 4, 9, 3]`

#### Step 1: Build root

- Call `build(0, 0, 5)`
- `mid = 2`
- Left child: `build(1, 0, 2)`
- Right child: `build(2, 3, 5)`

#### Step 2: Build left subtree `[0-2]`

- Node 1 → range `[0,2]`
- `mid = 1`
- Left child: `build(3, 0, 1)`
- Right child: `build(4, 2, 2)`

##### Node 3 `[0-1]`
- `mid = 0`
- Left child: `build(7, 0, 0)` → leaf → `tree[7] = 2`
- Right child: `build(8, 1, 1)` → leaf → `tree[8] = 5`
- Node 3 = `tree[7] + tree[8] = 2 + 5 = 7`

##### Node 4 `[2-2]` → leaf → `tree[4] = 1`

- Node 1 = `tree[3] + tree[4] = 7 + 1 = 8`

#### Step 3: Build right subtree `[3-5]`

- Node 2 → range `[3-5]`
- `mid = 4`
- Left child: `build(5, 3, 4)`
- Right child: `build(6, 5, 5)` → leaf → `tree[6] = 3`

##### Node 5 `[3-4]`
- `mid = 3`
- Left child: `build(11, 3, 3)` → leaf → `tree[11] = 4`
- Right child: `build(12, 4, 4)` → leaf → `tree[12] = 9`
- Node 5 = `tree[11] + tree[12] = 4 + 9 = 13`

- Node 2 = `tree[5] + tree[6] = 13 + 3 = 16`

#### Step 4: Compute root

- Node 0 (root) = `tree[1] + tree[2] = 8 + 16 = 24`

### Tree Filling Table

| Node | Range | Value |
|------|-------|-------|
| 0    | 0-5   | 24    |
| 1    | 0-2   | 8     |
| 2    | 3-5   | 16    |
| 3    | 0-1   | 7     |
| 4    | 2-2   | 1     |
| 5    | 3-4   | 13    |
| 6    | 5-5   | 3     |
| 7    | 0-0   | 2     |
| 8    | 1-1   | 5     |
| 11   | 3-3   | 4     |
| 12   | 4-4   | 9     |

---

**Summary:**
- The build function recursively fills the segment tree.
- Leaf nodes store array elements.
- Internal nodes combine child values.
- After building, `tree[0]` (root) contains the sum of the whole array.

---

## 15. Update Operation (Step-by-Step Explanation)

**Goal:** Update a single element in the array, e.g., `arr[2] = 10`.

We need to update the corresponding leaf node and propagate the change up the tree to keep sums correct.

**Update Function (0-based index):**
```java
void update(int node, int start, int end, int idx, int val) {
    if (start == end) {
        arr[idx] = val;
        tree[node] = val;
    } else {
        int mid = (start + end) / 2;
        if (idx <= mid) update(2 * node + 1, start, mid, idx, val);
        else update(2 * node + 2, mid + 1, end, idx, val);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
}
```

### Step-by-Step Example

Suppose `arr = [2, 5, 1, 4, 9, 3]` and we want to update `arr[2] = 10`.

Call: `update(0, 0, 5, 2, 10)` (root node)

**Step 1:** Root node (0, 0-5)
- mid = 2
- idx = 2 <= mid → go left child
- Call `update(1, 0, 2, 2, 10)`

**Step 2:** Node 1 (0-2)
- mid = 1
- idx = 2 > mid → go right child
- Call `update(4, 2, 2, 2, 10)`

**Step 3:** Node 4 (2-2)
- Leaf node → set `tree[4] = 10`, `arr[2] = 10`

**Step 4:** Backtrack and update parents
- Node 1 → `tree[1] = tree[3] + tree[4] = 7 + 10 = 17`
- Node 0 → `tree[0] = tree[1] + tree[2] = 17 + 16 = 33`

**Resulting tree:**
```
       [0-5] 33
      /        \
 [0-2] 17    [3-5] 16
 /   \        /    \
7   10   [3-4]13   3
```
- arr = [2, 5, 10, 4, 9, 3]

---

## 16. Query Operation (Step-by-Step Explanation)

**Goal:** Compute sum of elements in a given range `[l, r]`.

**Query Function (0-based index):**
```java
int query(int node, int start, int end, int l, int r) {
    if (r < start || l > end) return 0; // no overlap
    if (l <= start && end <= r) return tree[node]; // total overlap
    int mid = (start + end) / 2;
    int leftSum = query(2 * node + 1, start, mid, l, r);
    int rightSum = query(2 * node + 2, mid + 1, end, l, r);
    return leftSum + rightSum;
}
```

### Step-by-Step Example

Suppose we want to query sum in range `[1, 4]` after the above update.

Call: `query(0, 0, 5, 1, 4)` (root node)

**Step 1:** Root node (0-5)
- mid = 2
- Partial overlap: [1,4] covers both left [0,2] and right [3,5]
- Call left: `query(1, 0, 2, 1, 4)`
- Call right: `query(2, 3, 5, 1, 4)`

**Step 2:** Node 1 (0-2)
- mid = 1
- Partial overlap: [1,4] covers both left [0,1] and right [2,2]
- Call left: `query(3, 0, 1, 1, 4)`
- Call right: `query(4, 2, 2, 1, 4)`

**Step 3:** Node 3 (0-1)
- [1,4] overlaps with [0,1]
- Call left: `query(7, 0, 0, 1, 4)` → no overlap → return 0
- Call right: `query(8, 1, 1, 1, 4)` → total overlap → return tree[8] = 5
- Node 3 sum = 0 + 5 = 5

**Step 4:** Node 4 (2-2)
- [1,4] total overlap → return tree[4] = 10

- Node 1 sum = 5 + 10 = 15

**Step 5:** Node 2 (3-5)
- mid = 4
- [1,4] overlaps with left [3,4], right [5,5]
- Call left: `query(5, 3, 4, 1, 4)`
- Call right: `query(6, 5, 5, 1, 4)` → no overlap → return 0

**Step 6:** Node 5 (3-4)
- [1,4] total overlap → return tree[5] = 13

- Node 2 sum = 13 + 0 = 13

**Step 7:** Combine at root
- Total sum = left (15) + right (13) = 28

**Result:** sum in range [1,4] = 5 + 10 + 4 + 9 = 28

---

## 17. Key Concepts

| Concept         | Explanation |
|-----------------|-------------|
| Leaf node update| Update the element in arr and tree |
| Propagation     | Update parent nodes as tree[node] = tree[left] + tree[right] |
| Query types     | No overlap → return 0 (sum)<br>Total overlap → return tree[node]<br>Partial overlap → query left & right children, combine |

---

## 18. Visualization After Update

```
       [0-5] 33
      /        \
 [0-2] 17    [3-5] 16
 /   \        /    \
7   10   [3-4]13   3
```
- arr = [2, 5, 10, 4, 9, 3]
- tree[0] = sum [0-5] = 33
- tree[1] = sum [0-2] = 17
- tree[2] = sum [3-5] = 16
- tree[3] = sum [0-1] = 7
- tree[4] = sum [2-2] = 10
- tree[5] = sum [3-4] = 13
- tree[6] = sum [5-5] = 3

---

## 19. Lazy Propagation in Segment Trees

### 1️⃣ Motivation

A normal segment tree allows:
- Point Update (update one element) → O(log n)
- Range Query (sum/min/max over a range) → O(log n)

✅ But if we want Range Updates (update all elements in [l, r]), the naive approach requires updating each element → O(n log n) in worst case.

**Example:** Add +5 to all elements from arr[2..7].  
If we update one-by-one, it’s slow.

**Solution:** Lazy Propagation → allows efficient Range Updates + Range Queries in O(log n).

---

### 2️⃣ Key Idea

Instead of updating all affected nodes immediately,  
we store pending updates in a lazy array and only apply them when necessary (when visiting that node in a future query/update).

- `tree[]` → stores segment tree values (sum/min/max).
- `lazy[]` → stores pending updates for nodes that haven’t been pushed to children yet.

---

### 3️⃣ Example

Array:  
`arr = [1, 2, 3, 4, 5]`

Suppose we want: Add +2 to range [1,3]

- **Without Lazy:**  
  Update arr[1] += 2, arr[2] += 2, arr[3] += 2  
  Update segment tree → costly.

- **With Lazy:**  
  Mark node covering [1,3] with +2 in lazy[]  
  Only when we query inside [1,3], we apply the update.

---

### 4️⃣ Lazy Propagation Steps

**Range Update (add value to [l, r])**

1. If current node range is completely outside [l,r] → return.
2. If current node has pending lazy value, apply it first (push down).
3. If current node range is completely inside [l,r]:
    - Update tree[node] with val * segment_length
    - Store update in lazy[] for its children
    - Return (don’t go deeper).
4. If partial overlap, propagate to children, then update current node.

**Range Query (sum/min/max over [l, r])**

1. If current node has pending lazy value, apply it first.
2. If no overlap, return 0 (or ∞ for min).
3. If total overlap, return tree[node].
4. If partial overlap, query left and right children and combine.

---

### 5️⃣ Pseudocode

**Update Function**
```java
void updateRange(int node, int start, int end, int l, int r, int val) {
    // Step 1: Resolve lazy value if pending
    if (lazy[node] != 0) {
        tree[node] += (end - start + 1) * lazy[node]; // apply pending update
        if (start != end) { // not a leaf
            lazy[2*node+1] += lazy[node];
            lazy[2*node+2] += lazy[node];
        }
        lazy[node] = 0; // clear lazy value
    }

    // Step 2: Out of range
    if (start > r || end < l) return;

    // Step 3: Complete overlap
    if (start >= l && end <= r) {
        tree[node] += (end - start + 1) * val;
        if (start != end) {
            lazy[2*node+1] += val;
            lazy[2*node+2] += val;
        }
        return;
    }

    // Step 4: Partial overlap → go deeper
    int mid = (start + end) / 2;
    updateRange(2*node+1, start, mid, l, r, val);
    updateRange(2*node+2, mid+1, end, l, r, val);

    // Update current node
    tree[node] = tree[2*node+1] + tree[2*node+2];
}
```

**Query Function**
```java
int queryRange(int node, int start, int end, int l, int r) {
    // Step 1: Resolve lazy value if pending
    if (lazy[node] != 0) {
        tree[node] += (end - start + 1) * lazy[node];
        if (start != end) {
            lazy[2*node+1] += lazy[node];
            lazy[2*node+2] += lazy[node];
        }
        lazy[node] = 0;
    }

    // Step 2: Out of range
    if (start > r || end < l) return 0;

    // Step 3: Complete overlap
    if (start >= l && end <= r) return tree[node];

    // Step 4: Partial overlap → query children
    int mid = (start + end) / 2;
    int leftSum = queryRange(2*node+1, start, mid, l, r);
    int rightSum = queryRange(2*node+2, mid+1, end, l, r);

    return leftSum + rightSum;
}
```

---

### 6️⃣ Example Walkthrough

Array:  
`arr = [1, 2, 3, 4, 5]`

Initial tree (sum):  
`tree[0] = 15`

**Operation:** Add +2 to range [1,3]

- Update [1,3]:
    - Root [0,4] → partially overlaps → push down to children.
    - Node [1,3] fully inside → tree[node] += 2*(3 elements) = +6
    - Mark children with lazy +2.
- Now tree stores correct sum without directly changing arr.

**Query [2,4]:**
- When reaching node [2,3], apply lazy → add pending values.
- Return correct result.

---

### 7️⃣ Time Complexity

| Operation         | Normal Segment Tree | With Lazy Propagation |
|-------------------|--------------------|----------------------|
| Point Update      | O(log n)           | O(log n)             |
| Range Update      | O(n log n)         | O(log n)             |
| Range Query       | O(log n)           | O(log n)             |

---

### 8️⃣ Use Cases

- Range Add + Range Sum Queries
- Range Increment / Decrement
- Range Min/Max with Range Updates
- Problems in competitive programming (large arrays, frequent updates)

---

### 9️⃣ Diagram (for Sum Segment Tree with Lazy Update)

```
            [0-4] sum=15
           /             \
     [0-2] sum=6        [3-4] sum=9
     /      \            /     \
 [0-1]=3   [2]=3   [3]=4     [4]=5

Lazy update: +2 to [1-3]
→ Instead of updating arr[1],arr[2],arr[3],
  mark node [1-3] with lazy +2.
```

---

### ✅ Key Takeaway

Lazy Propagation allows fast range updates by delaying propagation of updates until necessary.  
It’s one of the most important optimizations for segment trees.

---
