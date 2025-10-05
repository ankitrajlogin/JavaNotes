

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

class SegmentTreeLazy{
    private int[] tree ; 
    private int[] lazy ; 
    private int n ; 

    public SegmentTreeLazy(int[] arr){
        this.n = arr.length ; 
        tree = new int[4*n] ; 
        lazy = new int[4*n] ; 

        build(arr , 0 , 0  , n-1) ; 
    }

    void build(int[] arr , int node , int start , int end){
        if(start == end){
            tree[node] = arr[start] ;
        }
        else{
            int mid = (start + end)/2 ; 
            build(arr , 2 * node + 1 , start , mid) ; 
            build(arr , 2 * node + 2 , mid + 1 , end) ; 
            tree[node] = tree[2*node + 1] + tree[2 * node + 2] ; 
        }
    }

    // Range Update : add val to all elements in [l , r]
    public void updateRange(int left , int right , int val){
        updateRange( 0 , 0 , n-1 , left , right , val) ; 
    }

    void updateRange(int node , int start , int end , int left , int right , int val){
        if(lazy[node] != 0){
            tree[node] += (end-start + 1)* lazy[node] ;

            if(start != end){
                lazy[2*node + 1] += lazy[node] ;
                lazy[2*node + 2] += lazy[node] ;
            }
            lazy[node] = 0 ; 
        }

        // out of range 
        if(start > right || end < left) return ; 

        // complete overlap 
        if(start >= left && end <= right){
            tree[node] += (end - start + 1)*val ; 

            if(start != end){
                tree[node] += (end - start + 1)*val ; 

                if(start != end){
                    lazy[2* node + 1] += val ; 
                    lazy[2* node + 2] += val ; 
                }

                return ; 
            }
        }

        // partial overlap 
        int mid = (start + end)/2 ; 
        updateRange(2*node + 1 , start , mid , left , right , val) ; 
        updateRange(2*node + 2 , mid + 1 , end , left, right, val);

        tree[node] = tree[2* node + 1] + tree[2* node + 2] ;
    }

    
    // range query : sum of elements in [l , r] ;
    public int queryRange(int left , int right){
        return queryRange(0 , 0 , n -1 , left , right) ; 
    }

    int queryRange(int node , int start ,int end , int left , int right){
        // resolve pending updates 
        if(lazy[node] != 0){
            tree[node] += (end - start + 1)* lazy[node] ;

            if(start != end){
                lazy[2* node + 1] += lazy[node] ;
                lazy[2* node + 2] += lazy[node] ;
            }

            lazy[node] = 0 ; 
        }

        // out of range 
        if(start > right  || end < left ) return  0 ; 

        // complete overlap 
        if(start >= left && end <= right) return tree[node] ;


        // partial overlap 
        int mid = (start + end)/2 ; 

        int leftSum = queryRange(2*node + 1, start , mid , left , right) ; 
        int rightSum = queryRange(2 * node + 2 , mid + 1 , end , left , right) ; 

        return leftSum + rightSum ; 
    } 

    public int[] getFinalArray(){
        int[] result = new int[n] ; 
        buildFinalArray(0 , 0 , n-1 , result) ; 

        return result ; 
    }

    public void buildFinalArray(int node , int start , int end , int[] result){
        // apply pending lazy values  ; 

        if(lazy[node] != 0){
            tree[node] += (end - start + 1)* lazy[node] ; 

            if(start != end){
                lazy[2 * node + 1] += lazy[node] ;
                lazy[2 * node + 2] += lazy[node] ; 
            }

            lazy[node] = 0 ; 
        }

        if(start == end){
            result[start] = tree[node] ; 
            return ; 
        }


        int mid = (start + end)/2 ; 

        buildFinalArray(2* node + 1 , start, mid ,  result);
        buildFinalArray(2* node + 2 , mid +1 , end, result);
    }
}



public class L02_Lazy_propogation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        SegmentTreeLazy st = new SegmentTreeLazy(arr);

        System.out.println("Initial sum of [0,4]: " + st.queryRange(0, 4)); // 15

        st.updateRange(1, 3, 2); // add +2 to [1,3]
        System.out.println("Sum of [0,4] after update: " + st.queryRange(0, 4)); // 21

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
