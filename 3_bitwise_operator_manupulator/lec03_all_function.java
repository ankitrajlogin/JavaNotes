import java.util.ArrayList;
import java.util.List;

class Operation{
    // count set bits in a number 
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // remove the last set bit
            count++;
        }
        return count;
    }

    public static int countSetBits2(int n ){
        int count = 0 ; 

        while(n != 0){
            count += (n &1) ; 
            n >>=1 ; 
        }

        return count ; 
    }

    // swap value of two variable . 
    public static void swap(int a, int b) {
        System.out.println("Before swap: a = " + a + ", b = " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After swap: a = " + a + ", b = " + b);
    }


    // print all subsets of a array ; 
    public static List<List<Integer>> getSubsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }

        return result;
    }









}



public class lec03_all_function {
    
}
