// Segment Tree for Range Sum
class SegmentTree {
    int[] tree, arr;
    int n;

    // Constructor
    SegmentTree(int[] input) {
        n = input.length;
        arr = input.clone();
        tree = new int[4 * n]; // safe size
        build(0, 0, n - 1);    // root at index 0, covers full range [0, n-1]
    }

    // Build function
    void build(int node, int left, int right) {
        if (left == right) {
            tree[node] = arr[left];
        } else {
            int mid = (left + right) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            build(leftChild, left, mid);
            build(rightChild, mid + 1, right);

            tree[node] = tree[leftChild] + tree[rightChild];
        }
    }

    // Query range sum [start, end]
    int query(int node, int left, int right, int start, int end) {
        if (end < left || start > right) return 0; // no overlap
        if (start <= left && right <= end) return tree[node]; // full overlap

        int mid = (left + right) / 2;
        int leftSum = query(2 * node + 1, left, mid, start, end);
        int rightSum = query(2 * node + 2, mid + 1, right, start, end);
        return leftSum + rightSum;
    }

    // Update value at index idx → new value val
    void update(int node, int left, int right, int idx, int val) {
        if (left == right) {
            arr[idx] = val;
            tree[node] = val;
        } else {
            int mid = (left + right) / 2;
            if (idx <= mid) update(2 * node + 1, left, mid, idx, val);
            else update(2 * node + 2, mid + 1, right, idx, val);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    // ===== Helper functions for external use =====

    int query(int start, int end) {
        if (start < 0 || end >= n || start > end) {
            throw new IllegalArgumentException("Invalid query range");
        }
        return query(0, 0, n - 1, start, end);
    }

    void update(int idx, int val) {
        if (idx < 0 || idx >= n) {
            throw new IllegalArgumentException("Invalid index");
        }
        update(0, 0, n - 1, idx, val);
    }

    // Print tree array
    void printTree() {
        System.out.println("Segment Tree Array:");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != 0)
                System.out.println("tree[" + i + "] = " + tree[i]);
        }
        System.out.println();
    }

    // Print original array
    void printArr() {
        System.out.println("Original Array:");
        for (int x : arr) System.out.print(x + " ");
        System.out.println("\n");
    }
}

// ============= Main =============
public class L01_SegmentTree_intro {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6};
        SegmentTree segTree = new SegmentTree(arr);

        segTree.printArr();
        segTree.printTree();

        System.out.println("Sum in range [1, 2]: " + segTree.query(1, 2));

        segTree.update(2, 10); // update arr[2] = 10
        segTree.printArr();
        segTree.printTree();

        System.out.println("Sum in range [1, 2] after update: " + segTree.query(1, 2));
    }
}
