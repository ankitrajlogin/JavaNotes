

/*

📝 Problem Statement

Problem: Cherry Pickup II (LeetCode 1463)

You are given a rows × cols grid representing a field of cherries.
    - Each cell (r, c) contains grid[r][c] cherries.
    - Two robots start at the top row:
        - Robot 1 at (0, 0) (top-left).
        - Robot 2 at (0, cols-1) (top-right).

    - Each robot moves down one row at a time.
    - At each step, a robot can move to:
          - (r+1, c-1) (down-left)
          - (r+1, c) (down)
          - (r+1, c+1) (down-right)

The robots collect cherries in the cells they visit.

If both robots land on the same cell, only one of them collects cherries from that cell (not double counted).

Your task is to return the maximum total number of cherries the two robots can collect.


 */




class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];

        // base case: last row
        for (int c1 = 0; c1 < cols; c1++) {
            for (int c2 = 0; c2 < cols; c2++) {
                if (c1 == c2) {
                    dp[rows - 1][c1][c2] = grid[rows - 1][c1];
                } else {
                    dp[rows - 1][c1][c2] = grid[rows - 1][c1] + grid[rows - 1][c2];
                }
            }
        }

        // fill table from bottom-2 row up to row 0
        for (int row = rows - 2; row >= 0; row--) {
            for (int c1 = 0; c1 < cols; c1++) {
                for (int c2 = 0; c2 < cols; c2++) {
                    int maxVal = Integer.MIN_VALUE;

                    // try all 9 moves
                    for (int move1 = -1; move1 <= 1; move1++) {
                        for (int move2 = -1; move2 <= 1; move2++) {
                            int newC1 = c1 + move1;
                            int newC2 = c2 + move2;

                            if (newC1 >= 0 && newC1 < cols && newC2 >= 0 && newC2 < cols) {
                                maxVal = Math.max(maxVal, dp[row + 1][newC1][newC2]);
                            }
                        }
                    }

                    int cherries = grid[row][c1];
                    if (c1 != c2) cherries += grid[row][c2];

                    dp[row][c1][c2] = cherries + maxVal;
                }
            }
        }

        // answer = start with robot1 at col0, robot2 at colN-1
        return dp[0][0][cols - 1];
    }
}

public class L05_Cherry_Pickup {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = {
            {3, 1, 1},
            {2, 5, 1},
            {1, 5, 5},
            {2, 1, 1}
        };

        int[][] grid2 = {
            {1, 0, 0, 0, 0, 0, 1},
            {2, 0, 0, 0, 0, 3, 0},
            {2, 0, 9, 0, 0, 0, 0},
            {0, 3, 0, 5, 4, 0, 0},
            {1, 0, 2, 3, 0, 0, 6}
        };

        System.out.println("Max cherries (grid1): " + sol.cherryPickup(grid1)); // 24
        System.out.println("Max cherries (grid2): " + sol.cherryPickup(grid2)); // 28
    }
}
