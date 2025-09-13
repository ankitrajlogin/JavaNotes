

/*

PROBLEM STATEMENT  : 
    - Given an array of integers arr[], find the contiguous subarray with the maximum sum that contains only non-negative numbers. If multiple subarrays have the same sum, return the one with the smallest starting index. If the array contains only negative numbers, return -1.

 */


/*

According to the question , subarray should not contain any negative number. 
and also for the case of multiple subarrays have the same sum , retun the one with the smallest starting index and maximum length ; 

And the array contains only negative numbers. return -1 ; 
 */

import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> findSubarray(int arr[]) {
        // code here
        int n = arr.length ; 
        
        int maxSum = 0 ; 
        int currSum = 0 ; 
        int start = -1 ; 
        int end = 0 ; 
        int tempStart = 0 ; 
        
        
        
        for(int i = 0 ; i< n ; i++){
            currSum += arr[i] ; 
            
            if(arr[i] < 0){
                tempStart = i+1 ; 
                currSum = 0 ; 
            }
            else if(currSum >= maxSum){
                maxSum = currSum ; 
                start = tempStart ; 
                end = i ; 
            }
        }
        
        ArrayList<Integer>result = new ArrayList<>() ; 
        
        if(maxSum == 0){
            result.add(-1) ; 
            return result ; 
        }
        
        for(int i = start ; i<=end ; i++){
            result.add(arr[i])  ; 
        }
        
        return result ; 
        
    }
}

public class Q05_Maximum_Sub_Array_with_no_negative_no {
    
    public static void main(String[] args){
        int[] arr = {4, -1 , 0 , 1 , 2 , 5 , 0 , -1 , 2 , 4 , -5 , 3} ; 

        ArrayList<Integer>ans = Solution.findSubarray(arr) ;

        System.out.println("answer is : " + ans) ; 
    }
}
