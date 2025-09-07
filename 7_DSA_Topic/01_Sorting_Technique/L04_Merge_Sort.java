

/* 
Merge Sort – Complete Notes
🔹 Definition

Merge Sort is a divide-and-conquer sorting algorithm that:

Recursively divides the array into two halves until each part has only one element.

Then merges the two halves back together in sorted order.

It is one of the most efficient general-purpose sorting algorithms with guaranteed O(n log n) time complexity.

🔹 Intuition

Think of sorting a deck of cards by splitting it into smaller piles:

Keep splitting the pile in half until each pile has only one card.

Then merge the piles back together in sorted order.

This is what Merge Sort does — break into smaller subproblems and then combine solutions.

🔹 Algorithm (Step-by-Step)

If the array has 0 or 1 element → already sorted (base case).

Otherwise:

Find the middle index.

Divide the array into two halves (left & right).

Recursively apply Merge Sort to each half.

Merge the two sorted halves into a single sorted array.
*/


import java.util.Arrays;

public class L04_Merge_Sort {

    public static void merge(int[] arr , int left , int mid , int right){
        // sizes of array 
        int[] newarr = new int[right-left+1] ;

        // merge two array s ; 
        int i = left ; 
        int j = mid+1  ; 
        int index = 0  ; 

        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                newarr[index] = arr[i] ;
                i++ ;  
            }
            else{
                newarr[index] = arr[j] ; 
                j++ ; 
            }
            index++ ; 
        }

        while(i <= mid){
            newarr[index] = arr[i] ;
            i++ ;  
            index++ ; 
        }

        while(j <=right){
            newarr[index] = arr[j] ; 
            j++ ; 
            index++ ; 
        }

        for(int k = 0 ; k < newarr.length ; k++){
            arr[left+k] = newarr[k] ; 
         }
    }

    public static void mergeSort(int[] arr , int left , int right){
        if(left >= right){
            return ; 
        }

        int mid = (left+right)/2 ; 

        mergeSort(arr , left , mid) ; 
        mergeSort(arr , mid+1 , right) ; 
        merge(arr , left , mid , right) ; 

    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original array: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);
        System.out.println("\nSorted array: " + Arrays.toString(arr)) ; 
    }
    
}



// ✅ In short:
// Merge Sort is a divide-and-conquer algorithm that recursively splits the array into halves, sorts them, and merges them back. It is stable, efficient (O(n log n)), and ideal for large datasets, but requires extra memory.