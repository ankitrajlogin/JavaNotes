
/*

Ninja Training Problem Statement
    A ninja wants to train for n days.
    Each day, he has exactly 3 activities to choose from:
        - Activity 0
        - Activity 1
        - Activity 2

Each activity gives him some number of points (different each day).
👉 Constraint: The ninja cannot perform the same activity on two consecutive days.
He wants to maximize the total points he can earn in n days.
 */

import java.util.Scanner;
import java.util.Arrays;


class Sol{
    // ---------- Memoization (Top-down) ----------
    // dp[idx][last] where last in {0,1,2,3}. last==3 means "no previous activity".
    public static int memoSolve(int[][] points) {
        int n = points.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return memoHelper(0, 3, points, dp);
    }

    private static int memoHelper(int idx, int last, int[][] points, int[][] dp) {
        int n = points.length;
        if (idx == n) return 0;
        if (dp[idx][last] != -1) return dp[idx][last];

        int max = 0;
        for (int task = 0; task < 3; task++) {
            if (task == last) continue;
            int ans = points[idx][task] + memoHelper(idx + 1, task, points, dp);
            if (ans > max) max = ans;
        }
        dp[idx][last] = max;
        return max;
    }

    // ---------- Tabulation (Bottom-up) ----------
    public static int tabulationSolve(int[][] points) {
        int n = points.length;
        // dp[i][last] = max points from day i..n-1 if last activity performed on previous day was 'last'
        int[][] dp = new int[n + 1][4]; // default 0 at dp[n][*]
        for (int i = n - 1; i >= 0; i--) {
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (task == last) continue;
                    int val = points[i][task] + dp[i + 1][task];
                    if (val > max) max = val;
                }
                dp[i][last] = max;
            }
        }
        return dp[0][3]; // starting at day 0 with no previous activity
    }

    // ---------- Space Optimized ----------
    public static int spaceOptimizedSolve(int[][] points) {
        int n = points.length;
        int[] next = new int[4]; // next corresponds to dp[i+1][*], starting dp[n][*] = {0,0,0,0}
        int[] cur = new int[4];

        for (int i = n - 1; i >= 0; i--) {
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (task == last) continue;
                    int val = points[i][task] + next[task];
                    if (val > max) max = val;
                }
                cur[last] = max;
            }
            // copy cur -> next (or swap)
            System.arraycopy(cur, 0, next, 0, 4);
        }
        return next[3];
    }


}

public class L01_NinjaTraining {

    
    // ---------- main: read input and run all three variants ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            System.out.println("No input found.");
            sc.close();
            return;
        }

        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println(0);
            sc.close();
            return;
        }

        int[][] points = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (sc.hasNextInt()) points[i][j] = sc.nextInt();
                else points[i][j] = 0; // safe fallback
            }
        }
        sc.close();

        // Run memoization
        int ansMemo = Sol.memoSolve(points);
        // Run tabulation
        int ansTab = Sol.tabulationSolve(points);
        // Run space optimized
        int ansSpace = Sol.spaceOptimizedSolve(points);

        // Print results
        System.out.println("Memoization result: " + ansMemo);
        System.out.println("Tabulation result: " + ansTab);
        System.out.println("Space-optimized result: " + ansSpace);
    }
}
