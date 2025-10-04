

// segmentTree for Sum
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
        System.out.println("node :" + node + " , start : " + start + " , end : " + end) ; 
        if (start == end) {
            System.out.println("node :" + node + " , start : " + start + " , end : " + end) ; 
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            System.out.println("mid :" + mid + ", leftChild : " + leftChild + " , righChild : " + rightChild) ;

            build(leftChild, start, mid);
            build(rightChild, mid + 1, end);

            tree[node] = tree[leftChild] + tree[rightChild];
        }
    }

    // Query range sum [l, r]
    int query(int node, int start, int end, int l, int r) {
        if (r < start || l > end) return 0; // no overlap
        if (l <= start && end <= r) return tree[node]; // full overlap
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
            if (idx <= mid) update(2 * node + 1, start, mid, idx, val);
            else update(2 * node + 2, mid + 1, end, idx, val);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    // Helper functions for easy usage
    int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    void update(int idx, int val) {
        update(0, 0, n - 1, idx, val);
    }

    // Function to print the segment tree array
    void printTree() {
        System.out.println("Segment Tree Array:");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != 0) // print only filled nodes for clarity
                System.out.println("tree[" + i + "] = " + tree[i]);
        }
        System.out.println();
    }

    // Function to print the original array
    void printArr() {
        System.out.println("Original Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}




public class L01_SegmentTree_intro {
    public static void main(String[] args) {
        int[] arr = {2,3,6};
        SegmentTree segTree = new SegmentTree(arr);

        segTree.printArr();
        segTree.printTree();

        System.out.println("Sum in range [1, 4]: " + segTree.query(1, 4));

        segTree.update(2, 10); // update arr[2] = 10
        segTree.printArr();
        segTree.printTree();

        System.out.println("Sum in range [1, 4] after update: " + segTree.query(1, 4));
    }
}
