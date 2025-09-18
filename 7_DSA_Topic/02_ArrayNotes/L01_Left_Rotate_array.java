import java.util.Arrays;

class Solution {
    void reverse(int[] arr , int left , int right ) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length ; 

        k = k% n ; 

        reverse(nums , 0 , n-1) ; 
        reverse(nums , 0 , k-1) ; 
        reverse(nums , k , n-1) ; 

    }
}

public class L01_Left_Rotate_array {
    public static void main(String[] args) {

        int nums[] = {1 , 2, 3 , 4, 5 , 6 ,7} ;

        System.out.println(Arrays.toString(nums)) ;


        Solution sol = new Solution() ; 

        sol.rotate(nums , 2) ;  // rotate by 2

        System.out.println(Arrays.toString(nums)) ; 
    }
}
