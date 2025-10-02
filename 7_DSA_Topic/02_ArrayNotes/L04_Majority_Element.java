

import java.util.*;

class Solution {
    public int majorityElementNby2(int[] nums) {
        int candidate = 0;
        int count = 0;

        // Step 1: Find a candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Verify (optional here since majority always exists)
        return candidate;
    }


    public List<Integer> majorityElementNby3(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;

        // 1st pass: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass: Verify the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }
}


public class L04_Majority_Element {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case for majorityElementNby2
        int[] nums1 = {2, 2, 1, 1, 1, 2, 2};
        int majorityNby2 = sol.majorityElementNby2(nums1);
        System.out.println("Majority Element (> n/2): " + majorityNby2);

        // Test case for majorityElementNby3
        int[] nums2 = {3, 2, 3};
        List<Integer> majorityNby3 = sol.majorityElementNby3(nums2);
        System.out.println("Majority Elements (> n/3): " + majorityNby3);

        int[] nums3 = {1, 2};
        System.out.println("Majority Elements (> n/3): " + sol.majorityElementNby3(nums3));

        int[] nums4 = {1, 2, 3, 1, 2, 1, 1};
        System.out.println("Majority Elements (> n/3): " + sol.majorityElementNby3(nums4));
    }
    
}
