import java.util.Arrays;


/* 
Bubble Sort 
    - Bubble Sort is a simple comparison-based sorting algorithm where adjacent elements are compared, and if they are in the wrong order, they are swapped. This process is repeated until the entire array is sorted.

    - It is called Bubble Sort because, in each pass, the largest element "bubbles up" to its correct position at the end of the array.


🔹 Intuition
    - Imagine air bubbles in water:
        - The lighter bubble moves upward step by step.
        - Similarly, in Bubble Sort, larger elements keep moving (or "bubbling") to the end after each pass.

    - So after the 1st pass, the largest element is in its correct position.
After the 2nd pass, the 2nd largest element is in its correct position, and so on…
    - Eventually, the array becomes sorted.

🔹 Algorithm (Step-by-Step)
    1. Start from the first element of the array.
    2. Compare the current element with the next element.
            - If the current element is greater → swap them.
    3. Move to the next pair and repeat until the last element.
    4. After each pass, the largest element settles at the end.
    5. Repeat the above process for all remaining elements (excluding the sorted ones at the end).
    6. Stop when no swaps are needed (array is sorted).

*/

public class L02_Bubble_Sort {

    // With recursion, we replace the outer loop by a recursive call.
    public static void recursiveBubbleSort(int[] arr , int n ){
        // Base case 
        if(n <= 1) return  ; 

        for(int i = 0 ; i< n-1 ; i++){
            if(arr[i] > arr[i+1]){
                int temp = arr[i] ;
                arr[i] = arr[i+1] ;
                arr[i+1] = temp; 
            }
        }

        recursiveBubbleSort(arr , n-1) ; 

    }

    // Function to perform bubble sort 
    public static void BubbleSort(int[] arr){

        int n = arr.length ; 
        
        // traverse through all elements ; 
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = 0 ; j < n-i-1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j] ; 
                    arr[j] = arr[j+1]  ; 
                    arr[j+1] = temp ; 
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 34, 23, 13};
        int[] arr2 = arr.clone() ; 

        System.out.println("Original array: " + Arrays.toString(arr));
        BubbleSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        System.out.println("\nOriginal array: " + Arrays.toString(arr2));
        recursiveBubbleSort(arr2 , arr2.length) ;
        System.out.println("Sorted array: " + Arrays.toString(arr2));
    }
    
}


// ✅ In short:
// Selection Sort repeatedly selects the minimum element from the unsorted part and places it in the correct position. It is simple, requires fewer swaps than Bubble Sort, but is still O(n²) and not suitable for large datasets.
