

import java.util.*;


class FrogJumpKDistance {

    // Function to calculate minimum cost
    public static int frogJump(int n, int k, int[] height) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // base case

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jumpCost = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    dp[i] = Math.min(dp[i], jumpCost);
                }
            }
        }
        return dp[n - 1]; // minimum cost to reach last step
    }

    
    
}



public class L01_Frog_jump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of steps (n): ");
        int n = sc.nextInt();

        System.out.print("Enter maximum jump distance (k): ");
        int k = sc.nextInt();

        int[] height = new int[n];
        System.out.println("Enter heights of each step:");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int result = FrogJumpKDistance.frogJump(n, k, height);
        System.out.println("Minimum cost for frog to reach step " + (n - 1) + " is: " + result);

        sc.close();
    }
}
