

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

public class L02_Lazy_propogation {
    
}
