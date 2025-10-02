import java.util.Arrays;

class Solu{
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find pivot (first decreasing element)
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find successor (element just larger than nums[i])
            int j = n - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: Swap pivot and successor
            swap(nums, i, j);
        }

        // Step 4: Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
         
}

public class L05_Next_Permutation {
    public static void main(String[] args) {
        Solu sol = new Solu();

        int[] nums1 = {1, 2, 3};
        sol.nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1)); // [1, 3, 2]

        int[] nums2 = {3, 2, 1};
        sol.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // [1, 2, 3]

        int[] nums3 = {1, 1, 5};
        sol.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // [1, 5, 1]
    
        int[] nums4 = {1, 1, 5,9, 8 , 6 , 5 , 4 ,3 ,1};
        sol.nextPermutation(nums4);
        System.out.println(Arrays.toString(nums4)); 
    }
}
