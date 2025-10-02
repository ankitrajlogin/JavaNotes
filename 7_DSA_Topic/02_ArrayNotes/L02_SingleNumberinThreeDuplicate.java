class Solution{
    // Time: O(32 * n) → O(n)

    public static int singleNumber(int[] nums){
        int result = 0 ; 

        // Go through all 32 bits of an integer 
        for(int i = 0 ; i< 32 ; i++){
            int sum = 0 ; 

            // count how many numbers have this bit set 
            for(int num : nums){
                if(((num >> i) & 1) == 1){
                    sum++ ; 
                } 
            }

            // If sum % 3!= 0 , that bit belongs to the unique number 
            if(sum%3 != 0){
                result |= (1 << i) ; 
            }
        }

        return result ;
    }
}

public class L02_SingleNumberinThreeDuplicate {
    public static void main(String[] args) {
        int[] nums = {9 , 2 , 2 ,2 , 3 , 4, 4, 4, 3 , 3} ;

        System.out.println(Solution.singleNumber(nums));
    }
}

