import java.util.Arrays;


/* 

🔹 Definition
    Selection Sort is a simple comparison-based sorting algorithm where the array is divided into two parts:
        1. Sorted part (initially empty)
        2. Unsorted part (initially the whole array)

    At each step, the smallest (or largest, depending on order) element from the unsorted part is selected and swapped with the first unsorted element, growing the sorted part one element at a time.



🔹 Intuition
    - Think of a teacher arranging students by height:
        - She finds the shortest student and moves them to the first position.
        - Then she finds the next shortest and places them in the second position, and so on.

    - That’s exactly how Selection Sort works — repeatedly selecting the minimum element and placing it 
    at the correct spot.



🔹 Algorithm (Step-by-Step)
    1. Start with the entire array unsorted.
    2. Find the minimum element in the unsorted part.
    3. Swap this minimum element with the first unsorted element.
    4. Now consider the first element sorted, and the rest as unsorted.
    5. Repeat until all elements are sorted.

*/



public class L01_Selection_Sort {

    public static void selectionSort(int[] arr){
        int n = arr.length ; 

        for(int i = 0 ; i < n ; i++){

            int smallest_index = i ; 

            for(int j = i+1 ; j < n ; j++){
                if(arr[smallest_index] > arr[j]){
                    smallest_index = j ; 
                }
            }

            int temp = arr[i];
            arr[i] = arr[smallest_index];
            arr[smallest_index] = temp; 
        }
    }

    public static void main(String[] args){

        int[] arr = {1, 23, 12 ,34 ,23, 13} ; 

        System.out.println("Original array : " + Arrays.toString(arr)) ; 


        selectionSort(arr);
        System.out.println("Sorted array : " + Arrays.toString(arr)) ;
    }
    
}



// ✅ In short:
// Bubble Sort is a simple, stable, in-place algorithm where the largest element “bubbles up” after each pass, but it is inefficient for large datasets due to O(n²) time complexity.