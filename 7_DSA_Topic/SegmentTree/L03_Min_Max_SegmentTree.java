class LazySegmentTree {

    class Node {
        int minimum;
        int maximum;

        Node(int minimum, int maximum) {
            this.minimum = minimum;
            this.maximum = maximum;
        }
    }

    int n;
    int[] arr;       // Keep a copy of the array
    Node[] st;
    int[] lazy;

    // Constructor
    LazySegmentTree(int[] input) {
        n = input.length;
        arr = input.clone(); // keep copy inside
        st = new Node[4 * n];
        lazy = new int[4 * n];
        build(0, 0, n - 1);
    }

    // Build segment tree from arr
    void build(int node, int start, int end) {
        if (start == end) {
            st[node] = new Node(arr[start], arr[start]);
        } else {
            int mid = (start + end) / 2;
            build(2 * node + 1, start, mid);
            build(2 * node + 2, mid + 1, end);

            st[node] = new Node(
                Math.min(st[2 * node + 1].minimum, st[2 * node + 2].minimum),
                Math.max(st[2 * node + 1].maximum, st[2 * node + 2].maximum)
            );
        }
    }

    String nodeToString(Node node) {
        return "Min=" + node.minimum + ", Max=" + node.maximum;
    }

    // Public query wrapper
    Node query(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private Node query(int node, int start, int end, int left, int right) {
        // Resolve lazy updates
        if (lazy[node] != 0) {
            st[node].minimum += lazy[node];
            st[node].maximum += lazy[node];

            if (start != end) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }

        // No overlap
        if (start > right || end < left) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Complete overlap
        if (start >= left && end <= right) {
            return st[node];
        }

        // Partial overlap
        int mid = (start + end) / 2;
        Node leftNode = query(2 * node + 1, start, mid, left, right);
        Node rightNode = query(2 * node + 2, mid + 1, end, left, right);

        return new Node(
            Math.min(leftNode.minimum, rightNode.minimum),
            Math.max(leftNode.maximum, rightNode.maximum)
        );
    }

    // Public range update
    void updateRange(int left, int right, int val) {
        updateRange(0, 0, n - 1, left, right, val);
    }

    private void updateRange(int node, int start, int end, int left, int right, int val) {
        // Resolve lazy updates
        if (lazy[node] != 0) {
            st[node].minimum += lazy[node];
            st[node].maximum += lazy[node];

            if (start != end) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }

        // No overlap
        if (start > right || end < left) return;

        // Complete overlap
        if (start >= left && end <= right) {
            st[node].minimum += val;
            st[node].maximum += val;

            if (start != end) {
                lazy[2 * node + 1] += val;
                lazy[2 * node + 2] += val;
            }

            // Also update arr copy
            for (int i = start; i <= end; i++) {
                arr[i] += val;
            }

            return;
        }

        // Partial overlap
        int mid = (start + end) / 2;
        updateRange(2 * node + 1, start, mid, left, right, val);
        updateRange(2 * node + 2, mid + 1, end, left, right, val);

        st[node].minimum = Math.min(st[2 * node + 1].minimum, st[2 * node + 2].minimum);
        st[node].maximum = Math.max(st[2 * node + 1].maximum, st[2 * node + 2].maximum);
    }

    // Optional: print current array copy
    void printArray() {
        System.out.print("Array state: ");
        for (int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}


public class L03_Min_Max_SegmentTree {
    public static void main(String[] args) {
        int[] arr = {1, 8, 5, 9, 6, 14, 2, 4, 3, 7};

        LazySegmentTree st = new LazySegmentTree(arr);

        System.out.println("Original Query [0,8]: " + st.nodeToString(st.query(0, 8)));

        st.updateRange(2, 6, 5); // update indices 2 to 6 by +5

        System.out.println("\nAfter Range Update [2,6] +5, Query [0,8]: " + st.nodeToString(st.query(0, 8)));

        System.out.println("\nQuery [3,5]: " + st.nodeToString(st.query(3, 5)));

        st.printArray(); // shows updated array copy
    }
}
