import java.util.HashSet;

class Solution {
    public static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            // check if this is the start of a sequence
            if (!set.contains(num - 1)) {
                int currNum = num;
                int streak = 1;

                // count consecutive numbers
                while (set.contains(currNum + 1)) {
                    currNum++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;
    }
}

public class L06_LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(Solution.longestConsecutive(arr1)); // 6

        int[] arr2 = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(Solution.longestConsecutive(arr2)); // 4

        int[] arr3 = {15, 13, 12, 14, 11, 10, 9};
        System.out.println(Solution.longestConsecutive(arr3)); // 7
    }
    
}
