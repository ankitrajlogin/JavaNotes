

/*
--------------------------
Lower Bound
--------------------------

    - The lower bound of a value x in a sorted array is the first index at which an element is greater than or equal to x.

    👉 In simpler words:
    It’s the position where x could be inserted in the array without breaking the sorting order.

*/


class BoundImplementation{
    public static int lowerBound(int[] arr , int target){
        int n = arr.length ; 
        int low = 0 ; 
        int high = n-1 ; 
        int ans = n ; 

        while(low <= high){
            int mid = (low + high)/2 ; 
            if(arr[mid] >= target){
                ans = mid ; 
                high = mid-1 ; 
            }
            else{
                low = mid+ 1; 
            }
        }

        return ans ;  
    }

    public static int lowerBound2(int[] arr , int target){
        int n = arr.length ; 

        int low = 0 ; 
        int high = n ; 

        while(low < high){
            int mid = (low + high)/2 ; 

            if(arr[mid] < target){
                low = mid + 1 ; 
            }
            else{
                high = mid ; 
            }
        }

        return low ;
        
    }


    public static int upperBound(int[] arr , int target){
        int n = arr.length ; 

        int low = 0 ; 
        int high = n-1 ; 
        int ans = n ; 

        while(low <= high){
            int mid = (low + high)/2 ;

            if(arr[mid] > target){
                ans = mid ; 
                high = mid - 1; 
            }
            else{
                low = mid + 1 ; 
            }
        }
        return ans ; 
    }

    public static int upperBound2(int[] arr , int target){
        int n = arr.length ; 

        int low = 0 ; 
        int high = n-1 ; 
        int ans = n ; 

        while(low <= high){
            int mid = (low + high)/2 ; 
            if(arr[mid] >= target){
                ans = mid ; 
                high = mid - 1 ; 
            }
            else{
                low = mid + 1 ; 
            }
        }

        return ans ; 
    }
}





public class L02_Lower_Upper_bound {
    public static void main(String[] args) {
        int arr[] = {2, 4, 4, 7, 9, 12};
        
        System.out.println("Lower bound of 4: " + BoundImplementation.lowerBound(arr, 4));  // 1
        System.out.println("Lower bound of 5: " + BoundImplementation.lowerBound(arr, 5));  // 3
        System.out.println("Lower bound of 1: " + BoundImplementation.lowerBound(arr, 1));  // 0
        System.out.println("Lower bound of 15: " + BoundImplementation.lowerBound(arr, 15));// 6
    }
}
