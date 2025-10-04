import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class L03_Inbuild_heap {
    public static void main(String[] args){

        // Min-heap (default) 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>() ; 

        // Max-Heap (custom comparator)
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Collections.reverseOrder()) ; 


        minHeap.add(10);    // Insert element
        minHeap.offer(5);   // Alternative insert  -- this is used of queue ( but in priority queue , it act as same as add) 
        minHeap.add(20);

        System.out.println(minHeap);  // Output order not guaranteed, but heap property maintained


        // Peek ( get root without removing)
        System.out.println("Min element : " + minHeap.peek()) ; 

        // Poll / Remove (extract root) 
        System.out.println("Removed: " + minHeap.poll()); // removes and returns smallest
        System.out.println("Removed: " + minHeap.remove()); // same as poll(), throws exception if empty


        // Delete specific element 
        minHeap.remove(10) ; // removes element "10" if present 


        // size & empty check 
        System.out.println("size: " + minHeap.size()) ; 
        System.out.println("Is empty? " + minHeap.isEmpty()) ; 



        // Heap sort using PriorityQueue
        PriorityQueue<Integer> heapSort = new PriorityQueue<>(Arrays.asList(5, 3, 8, 1, 2));
        while (!heapSort.isEmpty()) {
            System.out.print(heapSort.poll() + " "); // prints in ascending order
        }





    }

    
}



/*

// Time & Space Complexity Table 

| Operation                | Complexity   |
| ------------------------ | ------------ |
| Insert (add/offer)       | `O(log n)`   |
| Get Min/Max (peek)       | `O(1)`       |
| Extract Min/Max (poll)   | `O(log n)`   |
| Delete specific element  | `O(n)`       |
| Search (contains)        | `O(n)`       |
| Size / isEmpty           | `O(1)`       |
| Build Heap (constructor) | `O(n)`       |
| Heap Sort                | `O(n log n)` |



 */