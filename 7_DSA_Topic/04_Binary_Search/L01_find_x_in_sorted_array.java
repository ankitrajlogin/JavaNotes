

/* 
------------------------------
Binary Search
------------------------------
    - Binary Search is one of the most efficient searching algorithms that works on the principle of Divide and Conquer.
    - It is used to find the position of a target element within a sorted array or list.
    - Instead of checking elements one by one (like linear search), it repeatedly divides the search interval into half, reducing the time complexity significantly.

*/

class BinarySearch{
    public static int RecursiveBinarySearch(int arr[] , int low , int high , int target){
        if(low > high) return -1 ; 

        int mid = (low+high)/2 ; 

        if(arr[mid] == target) return mid ; 
        else if(arr[mid] > target) return RecursiveBinarySearch(arr, low, mid-1, target) ; 
        else return RecursiveBinarySearch(arr, mid+1, high, target) ;
    }


    public static int IterativeBinarySearch(int arr[] , int low , int high , int target){
    
        while(low <= high){
            int mid = (low + high)/2 ; 

            if(arr[mid] == target) return mid ; 
            else if(target > arr[mid]) low = mid + 1 ; 
            else high = mid - 1 ; 
        }

        return -1 ;
    }
}


public class L01_find_x_in_sorted_array {

    public static void main(String[] args){

        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;
        int low = 0 ; 
        int high = a.length -1 ; 
    
        int ind = BinarySearch.RecursiveBinarySearch(a, low , high , target);
        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);
    
    
        int ind2 = BinarySearch.RecursiveBinarySearch(a, low, high, target) ; 
        if (ind2 == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind2);
            
    }

}
