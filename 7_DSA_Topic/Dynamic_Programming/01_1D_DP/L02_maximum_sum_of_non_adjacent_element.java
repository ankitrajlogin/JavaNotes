

public class L02_maximum_sum_of_non_adjacent_element {

    // Function to calculate maximum sum of non-adjacent elements
    public static int maxNonAdjacentSum(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

    // Optimized version with O(1) space
    public static int maxNonAdjacentSumOptimized(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            int current = Math.max(prev1, arr[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9, 2};  // Hardcoded array

        int result = maxNonAdjacentSum(arr);
        System.out.println("Maximum sum of non-adjacent elements: " + result);

        int resultOptimized = maxNonAdjacentSumOptimized(arr);
        System.out.println("Maximum sum (Optimized): " + resultOptimized);
    }
}
