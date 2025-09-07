import java.util.Arrays;

/* 
Insertion Sort
    - Insertion Sort is a simple comparison-based sorting algorithm that builds the final sorted array one element at a time.

    - It works the same way as sorting playing cards in your hand:
        - Pick the next card.
        - Compare it with the cards in hand.
        - Insert it into its correct position.



🔹 Intuition
    - Imagine arranging cards in your hand while playing:
        - You pick the next card from the deck.
        - You shift the larger cards one step to the right.
        - You insert the card at the correct position.

    This is exactly what Insertion Sort does for arrays.



🔹 Algorithm (Step-by-Step)
    1. Assume the first element is already sorted.
    2. Pick the next element (key).
    3. Compare key with elements in the sorted part (left side).
    4. Shift larger elements one step to the right.
    5. Insert the key into the correct position.
    6. Repeat until the array is fully sorted.
*/




public class L03_Insertion_Sort {

    public static void recuriveInsertionSort(int arr[] , int n){
        if(n <=1) return ; 
        // Recursive version does the same thing, but:
        //      - First, it recursively sorts the first n-1 elements.
        //      - Then inserts the nth element into its correct position in the sorted part.

        recuriveInsertionSort(arr , n-1) ; 

        // Insert last element at its correct position 
        int last = arr[n-1] ;
        int j = n-2 ;

        while(j >= 0 && arr[j] > last){
            arr[j+1] = arr[j] ; 
            j-- ; 
        }
        arr[j+1] = last ; 
    }




    public static void InsertionSort(int[] arr){
        int n = arr.length ; 

        for(int i = 1 ; i < n ; i++){
            for(int j = i ; j > 0 ; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j] ;
                    arr[j] = arr[j-1] ; 
                    arr[j-1] = temp ; 
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 34, 23, 13};
        int[] arr2 = arr.clone() ; 

        System.out.println("Original array: " + Arrays.toString(arr));

        InsertionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));


        System.out.println("\nOriginal array: " + Arrays.toString(arr2));

        recuriveInsertionSort(arr2 , arr.length);
        System.out.println("Sorted array: " + Arrays.toString(arr2));
    }
    
}


// ✅ In short:
// Insertion Sort builds the sorted array one element at a time by inserting each element into its correct position. It is stable, adaptive, and efficient for small or nearly sorted datasets, but not suitable for large arrays.