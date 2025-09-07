import java.util.Arrays;

public class Q01_0_1_2_sorting {
    public static void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sortColors(int[] nums) {
        int zero = 0;          // boundary for 0
        int one = 0;           // current index
        int two = nums.length - 1; // boundary for 2

        while(one <= two){
            if(nums[one] == 0){
                swap(nums , zero , one);
                zero++;
                one++;   // ✅ move both
            }
            else if(nums[one] == 1){
                one++;   // ✅ just move
            }
            else { // nums[one] == 2
                swap(nums , one , two);
                two--;   // ✅ only move `two`
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {2 , 1, 2, 0 , 0 , 1 ,2 , 0} ; 

        System.out.println("original arr : " + Arrays.toString(arr));

        sortColors(arr) ; 
        System.out.println("Sorted array : " + Arrays.toString(arr) ) ; 

    }
    
}
