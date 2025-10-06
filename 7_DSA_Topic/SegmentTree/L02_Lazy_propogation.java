

/*
-----------------------------------------------------
Lazy Propagation in Segment Trees 
-----------------------------------------------------

A normal segment tree allows:
    - Point Update (update one element) → O(log n)
    - Range Query (sum/min/max over a range) → O(log n)

But if we want Range Updates (update all elements in [l, r]), the naive approach requires updating each element → O(n log n) in worst case.

Example: Add +5 to all elements from arr[2..7].
If we update one-by-one, it’s slow.

Solution: Lazy Propagation → allows efficient Range Updates + Range Queries in O(log n).




2️⃣ Key Idea
-------------------

Instead of updating all affected nodes immediately,
we store pending updates in a lazy array and only apply them when necessary (when visiting that node in a future query/update).
    - tree[] → stores segment tree values (sum/min/max).
    - lazy[] → stores pending updates for nodes that haven’t been pushed to children yet.


 */


 class SegmentTreeLazy {
    private int[] tree;
    private int[] lazy;
    private int n;

    // Constructor
    public SegmentTreeLazy(int[] arr) {
        this.n = arr.length;
        tree = new int[4 * n];
        lazy = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    // Build function
    private void build(int[] arr, int node, int left, int right) {
        if (left == right) {
            tree[node] = arr[left];
        } else {
            int mid = (left + right) / 2;
            build(arr, 2 * node + 1, left, mid);
            build(arr, 2 * node + 2, mid + 1, right);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    // Public wrapper for range update
    public void updateRange(int start, int end, int val) {
        updateRange(0, 0, n - 1, start, end, val);
    }

    // Range Update: add val to all elements in [start, end]
    private void updateRange(int node, int left, int right, int start, int end, int val) {
        // resolve pending lazy
        if (lazy[node] != 0) {
            tree[node] += (right - left + 1) * lazy[node];
            if (left != right) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }

        // out of range
        if (right < start || left > end) return;

        // complete overlap
        if (start <= left && right <= end) {
            tree[node] += (right - left + 1) * val;
            if (left != right) {
                lazy[2 * node + 1] += val;
                lazy[2 * node + 2] += val;
            }
            return;
        }

        // partial overlap
        int mid = (left + right) / 2;
        updateRange(2 * node + 1, left, mid, start, end, val);
        updateRange(2 * node + 2, mid + 1, right, start, end, val);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    // Public wrapper for range query
    public int queryRange(int start, int end) {
        return queryRange(0, 0, n - 1, start, end);
    }

    // Query sum in [start, end]
    private int queryRange(int node, int left, int right, int start, int end) {
        // resolve pending lazy
        if (lazy[node] != 0) {
            tree[node] += (right - left + 1) * lazy[node];
            if (left != right) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }

        // out of range
        if (right < start || left > end) return 0;

        // complete overlap
        if (start <= left && right <= end) return tree[node];

        // partial overlap
        int mid = (left + right) / 2;
        int leftSum = queryRange(2 * node + 1, left, mid, start, end);
        int rightSum = queryRange(2 * node + 2, mid + 1, right, start, end);

        return leftSum + rightSum;
    }

    // Reconstruct final array after all lazy updates
    public int[] getFinalArray() {
        int[] result = new int[n];
        buildFinalArray(0, 0, n - 1, result);
        return result;
    }

    private void buildFinalArray(int node, int left, int right, int[] result) {
        // apply pending lazy values
        if (lazy[node] != 0) {
            tree[node] += (right - left + 1) * lazy[node];
            if (left != right) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }

        if (left == right) {
            result[left] = tree[node];
            return;
        }

        int mid = (left + right) / 2;
        buildFinalArray(2 * node + 1, left, mid, result);
        buildFinalArray(2 * node + 2, mid + 1, right, result);
    }
}


public class L02_Lazy_propogation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        SegmentTreeLazy st = new SegmentTreeLazy(arr);

        System.out.println("Initial sum of [0,4]: " + st.queryRange(0, 4)); // 15

        st.updateRange(0, 3, 2); // add +2 to [1,3]
        System.out.println("Sum of [0,4] after update with val 2: " + st.queryRange(0, 4)); // 21

        st.updateRange(0, 2, 1); // add +1 to [0,2]
        System.out.println("Sum of [2,4] after update: " + st.queryRange(2, 4)); // 17

        // Get final updated array
        int[] finalArr = st.getFinalArray();
        System.out.print("Final Updated Array: ");
        for (int val : finalArr) {
            System.out.print(val + " ");
        }
    }
}
