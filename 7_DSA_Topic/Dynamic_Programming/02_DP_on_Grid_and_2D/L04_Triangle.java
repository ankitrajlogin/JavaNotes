
/*

Problem: LeetCode 120 – Triangle

We are given a triangle of integers in the form of a list of lists, like this:
   2
  3 4
 6 5 7
4 1 8 3

    - We start at the top element (2).
    - At each step, we can move to adjacent numbers on the row just below.

    - If we are at index i in row r,
    - we can go to either index i or i+1 in row r+1.

    - Our goal is to find the minimum path sum from the top to the bottom.

 */


 import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // Initialize dp with the last row
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Bottom-up calculation
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }

    
   
}


public class L04_Triangle {
     public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3, 4));
        triangle1.add(Arrays.asList(6, 5, 7));
        triangle1.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(sol.minimumTotal(triangle1)); // Output: 11

        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(Arrays.asList(-10));
        System.out.println(sol.minimumTotal(triangle2)); // Output: -10
    }
}
