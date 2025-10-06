import java.util.*;

class LeftMostMaxBuilding {
    int n;
    int[] segmentTree;
    int[] heights;

    // Construct Segment Tree
    void constructST(int[] heights) {
        n = heights.length;
        segmentTree = new int[n * 4];
        this.heights = heights.clone();
        buildSegmentTree(0, 0, n - 1);
    }

    // Build Segment Tree (store index of max element)
    private void buildSegmentTree(int node, int left, int right) {
        if (left == right) {
            segmentTree[node] = left; // store index
            return;
        }

        int mid = (left + right) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        buildSegmentTree(leftChild, left, mid);
        buildSegmentTree(rightChild, mid + 1, right);

        // pick index of larger height (if equal -> pick leftmost)
        int leftIndex = segmentTree[leftChild];
        int rightIndex = segmentTree[rightChild];

        segmentTree[node] = (heights[leftIndex] >= heights[rightIndex]) ? leftIndex : rightIndex;
    }

    // Query for maximum index in range [start, end]
    int queryMaxIndex(int start, int end) {
        if (start < 0 || end >= n || start > end) {
            throw new IllegalArgumentException("Invalid query range");
        }
        return querySegmentTree(0, 0, n - 1, start, end);
    }

    private int querySegmentTree(int node, int left, int right, int start, int end) {
        // completely outside range
        if (left > end || right < start) return -1;

        // completely inside range
        if (left >= start && right <= end) return segmentTree[node];

        // partially overlap
        int mid = (left + right) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        int leftIndex = querySegmentTree(leftChild, left, mid, start, end);
        int rightIndex = querySegmentTree(rightChild, mid + 1, right, start, end);

        if (leftIndex == -1) return rightIndex;
        if (rightIndex == -1) return leftIndex;

        // choose leftmost max index
        return (heights[leftIndex] >= heights[rightIndex]) ? leftIndex : rightIndex;
    }

    // Update query : update heights[pos] = newVal ; 

    void update(int pos , int newVal){
        if(pos < 0 || pos >= n){
            throw new IllegalArgumentException("Invalid update index") ; 
        }

        heights[pos] = newVal ; 

        updateSegmentTree(0 , 0 , n-1 , pos) ; 
    }

    private void updateSegmentTree(int node , int left , int right , int pos){
        if(left == right){
            segmentTree[node] = left ; 
            return ; 
        }

        int mid = (left + right)/2 ; 

        if(pos <= mid){
            updateSegmentTree(2*node + 1 , left , mid , pos);
        }
        else{
            updateSegmentTree(2*node + 2 , mid + 1 , right , pos);
        }

        int leftIndex = segmentTree[2 * node + 1] ; 
        int rightIndex = segmentTree[2* node + 2] ; 

        segmentTree[node] = (heights[leftIndex] >= heights[rightIndex]) ? leftIndex : rightIndex ; 
    }
}


// Range Update with lazy propagation 
class LeftMostMaxBuildingLazy{
    int n ; 
    int[] segmentTree ; 
    int[] heights ; 
    int[] lazy ; 

    void constructST(int[] heights){
        n = heights.length ; 
        segmentTree = new int[n*4] ;
        lazy = new int[n*4] ; 
        this.heights = heights.clone() ; 
        
        buildSegmentTree(0  , 0 , n -1) ; 
    }

    private void buildSegmentTree(int node , int left , int right){
        if(left == right){
            segmentTree[node] = left ;
            return ; 
        }

        int mid = (left + right)/2 ; 

        int leftChild = 2 * node + 1; 
        int rightChild = 2 * node + 2  ; 

        buildSegmentTree(leftChild , left , mid) ; 
        buildSegmentTree(rightChild , mid+ 1 , right) ; 

        
        int leftIndex = segmentTree[leftChild]  ; 
        int rightIndex = segmentTree[rightChild] ; 

        segmentTree[node] = (heights[leftIndex] >= heights[rightIndex]) ? leftIndex : rightIndex ; 
    }

    void updateRange(int start , int end , int val){
        updateRange(0 , 0 , n-1 , start , end , val) ; 
    }

    private void updateRange(int node , int left , int right , int start , int end , int val){
        if(lazy[node] != 0){
            int idx = segmentTree[node] ; 
            heights[idx] += lazy[node] ; 

            if(left != right){
                lazy[2* node + 1] += lazy[node] ; 
                lazy[2* node + 1] += lazy[node] ; 
            }

            lazy[node] = 0 ; 
        }

        if(left > end || right < start) return ; 

        if(left >= start && right <= end){
            lazy[node] += val ;  // as it is maximum or minimum value store so adding just val other wise (lazy[node] += val*(right-left) , for the sum type)
            
        }
    }

    
}



// Main Class to Test
public class L04_RightMaxQuery {
   public static void main(String[] args) {
        int[] heights = {2, 1, 5, 3, 5, 2, 4};

        LeftMostMaxBuilding tree = new LeftMostMaxBuilding();
        tree.constructST(heights);

        // Queries
        int[][] queries = {
            {0, 3},  // max in [0..3]
            {2, 4},  // max in [2..4]
            {0, 6},  // whole range
            {4, 6}   // last part
        };

        for (int[] q : queries) {
            int idx = tree.queryMaxIndex(q[0], q[1]);
            System.out.println("Range [" + q[0] + ", " + q[1] + "] -> " +
                               "Max Height = " + tree.heights[idx] + " at index " + idx);
        }

        // Test update
        System.out.println("\nUpdating index 2 -> 10");
        tree.update(2, 10);

        int idx = tree.queryMaxIndex(0, 6);
        System.out.println("After update: Max Height = " + tree.heights[idx] + " at index " + idx);
    }
}
