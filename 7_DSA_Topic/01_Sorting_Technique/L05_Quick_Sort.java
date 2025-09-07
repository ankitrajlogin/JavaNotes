import java.util.Arrays;

/*

🔹 Definition
    Quick Sort is a divide-and-conquer sorting algorithm that:
        1. Picks a pivot element.
        2. Partitions the array so that:
            - Elements smaller than pivot go to the left.
            - Elements greater than pivot go to the right.
        3. Recursively applies Quick Sort to left and right subarrays.

It is one of the fastest sorting algorithms in practice with O(n log n) average time complexity.


🔹 Intuition
Think of arranging students around a leader (pivot):
    - The leader stands in the middle.
    - Shorter students go to the left, taller students to the right.
    - Then each group arranges itself in the same way.

That’s exactly how Quick Sort works — partitioning around a pivot.



🔹 Algorithm (Step-by-Step)
    1. Choose a pivot element (can be first, last, middle, or random).
    2. Rearrange elements so that all elements less than pivot are before it, and all greater are after it (partition step).
    3. Recursively apply Quick Sort to left and right subarrays.
    4. Stop when subarray has 0 or 1 element (already sorted).


 */

public class L05_Quick_Sort {

    public static int partition(int[] arr , int low , int high){

        int pivot = arr[high] ; 
        
        int i = low-1 ; 

        for(int j = low ; j < high ; j++){
            if(arr[j] < pivot){
                i++ ; 

                int temp = arr[i] ; 
                arr[i] = arr[j] ; 
                arr[j] = temp ; 
            }
        }

        int temp = arr[i+1] ; 
        arr[i+1] = arr[high] ; 
        arr[high] = temp ; 

        return i+1 ; 
    }



    public static void quickSort(int[] arr , int low , int high){
        if(low >= high){
            return ; 
        }
        int pivotIndex = partition(arr , low , high) ; 
        quickSort(arr, low, pivotIndex-1);
        quickSort(arr , pivotIndex+1 , high);

    }

     public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original array: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println("\nSorted array: " + Arrays.toString(arr)) ; 
    }
    
}



// ✅ In short:
// Quick Sort is a divide-and-conquer algorithm that partitions the array around a pivot and recursively sorts subarrays. It is very fast (O(n log n) average), in-place, but not stable and can degrade to O(n²) in the worst case without randomized pivoting.
