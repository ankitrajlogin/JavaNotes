import java.util.Arrays;


// Dutch National Flag Algorithm
class Solution{

    public static void swap(int[] nums , int i , int j){
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ; 
    }

    public static void sort(int[] nums){
        int n = nums.length ; 

        int one = 0 ; 
        int zero = 0 ; 
        int two = n-1 ; 

        while(one <= two){
            if(nums[one] == 1){
                one++ ; 
            }
            else if(nums[one] == 0){
                swap(nums , one , zero) ; 
                zero++ ; 
            }
            else if(nums[one] == 2){
                swap(nums , one , two) ; 
                two-- ; 
            }
        }
    }
}

public class L03_Sort_0_1_2_array {
    public static void main(String[] args) {
        
        int[] nums = {1 , 0 , 2, 2 ,0 , 1 , 2 , 0 , 0 , 0} ;

        System.out.println(Arrays.toString(nums)) ; 
        Solution.sort(nums) ; 

        System.out.println(Arrays.toString(nums)) ; 
    }
}
