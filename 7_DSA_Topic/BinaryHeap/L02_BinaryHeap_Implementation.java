import java.util.ArrayList;

class BinaryHeap{
    private ArrayList<Integer> heap ; 

    //constructor 
    public BinaryHeap(){
        heap = new ArrayList<>() ; 
    }

    // 1. get parent index 
    int parent(int i){
        return (i-1)/2 ; 
    }

    // 2. get left child index
    int leftChild(int i){
        return 2*i + 1 ; 
    }

    // 3. get right child index
    int rightChild(int i){
        return 2*i + 2 ; 
    }

    // 4. Insert a new element into heap 
    void insert(int val){
        heap.add(val) ; 
        int index = heap.size() -1 ; 
        heapifyUp(index) ; 
    }

    // 5. Heapify up (bubble up) -- Max - Heap condition 
    void heapifyUp(int index){
        while(index > 0 && heap.get(parent(index)) < heap.get(index)){
            swap(index , parent(index)) ; 
            index = parent(index) ; 
        }
    }

    void swap(int i , int j){
        int temp = heap.get(i) ; 
        heap.set(i , heap.get(j)) ; 
        heap.set(j , temp) ; 
    }

    // Remove and return root ( max element)
    int extractMax(){
        if(heap.isEmpty()) return -1 ; 

        int root = heap.get(0) ; 
        int last = heap.remove(heap.size() -1 ) ; 

        if(!heap.isEmpty()){
            heap.set(0 , last) ; 
            heapifyDown(0) ; 
        }

        return root ; 
    }

    // Heapify down ( bubble down) 
    void heapifyDown(int index){
        int size = heap.size() ; 

        while(true){
            int largest = index ; 
            int left = leftChild(index) ; 
            int right = rightChild(index) ; 

            if(left < size && heap.get(left) > heap.get(largest)){
                largest = left ; 
            }

            if(right < size && heap.get(right) > heap.get(largest)){
                largest = right ; 
            }

            if(largest != index){
                swap(index , largest) ; 
                index = largest ; 
            }
            else{
                break;  
            }
        }
    }

    // 6. Delete a node at given index 
    void delete(int index){
        if(index >= heap.size()) return ; 

        // Replace with last element 
        int last = heap.remove(heap.size() - 1) ; 

        if(index < heap.size()){
            heap.set(index , last) ; 

            // Heapify both ways 
            heapifyDown(index); 
            heapifyUp(index); 
        }
    }

    
    // 7. Build heap from array 
    void buildHeap(int[] arr){
        heap.clear() ; 

        for(int val : arr) heap.add(val) ; 

        int n = heap.size() ; 
        for(int i = n/2 -1 ; i>= 0 ; i--){
            heapifyDown(i) ;
        }
    }

    // 8. Peek at root (max element)
    public int peek() {
        if (heap.isEmpty()) return -1;
        return heap.get(0);
    }

    // 9. Print heap array
    public void printHeap() {
        System.out.println(heap);
    }

    // 10. Heap size
    public int size() {
        return heap.size();
    }

    // 11. Check if heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}


public class L02_BinaryHeap_Implementation {
public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();

        // Insert elements
        heap.insert(50);
        heap.insert(30);
        heap.insert(20);
        heap.insert(40);
        heap.insert(10);

        System.out.println("Heap after insertions: ");
        heap.printHeap(); // [50, 40, 20, 30, 10]

        // Extract max
        System.out.println("Extracted max: " + heap.extractMax());
        heap.printHeap(); // [40, 30, 20, 10]

        // Delete element at index 1 (30)
        heap.delete(1);
        System.out.println("Heap after deleting index 1: ");
        heap.printHeap(); // [40, 10, 20]

        // Build heap from array
        int[] arr = {3, 5, 9, 6, 8, 20};
        heap.buildHeap(arr);
        System.out.println("Heap after building from array: ");
        heap.printHeap(); // [20, 8, 9, 6, 5, 3]

        // Peek max
        System.out.println("Max element: " + heap.peek()); // 20
    }
}
