
/*
Notes on 2D Dynamic Programming (DP) in Java
--------------------------------------------

1. 🔹 What is 2D DP?
        Dynamic Programming (DP) solves problems by breaking them into smaller overlapping subproblems and storing results to avoid recomputation.
        2D DP uses a 2D array (dp[i][j]) to represent states where:
            - i = one dimension (e.g., index of array/string/matrix row)
            - j = second dimension (e.g., another index/column/choice/constraint)

        Examples of dp[i][j]:
            - Minimum cost to reach cell (i, j) in a grid
            - Whether substring from i to j is palindrome
            - Maximum profit using i items and j capacity in knapsack
            - Longest Common Subsequence length of prefixes s1[0..i] and s2[0..j]



2. 🔹 How to Identify a 2D DP Problem?
        Ask yourself:
            - Does the state depend on two variables? (e.g., index of string1 and string2)
            - Are you solving for a 2D structure (matrix, grid, chessboard)?
            - Does the recurrence require two dimensions of choices?
            - Do you need to track both "choices" and "resources"? (e.g., items × capacity in knapsack)
        If two independent factors determine the answer, it’s a 2D DP.



3. 🔹 General Steps to Write 2D DP
        - Define State (dp array meaning): Clearly define what dp[i][j] represents.
            Example: dp[i][j] = length of LCS of s1[0..i-1] and s2[0..j-1]
        - Initialize Base Cases: Handle smallest subproblems (empty string, first row/col of grid).
        - Write Recurrence Relation: Express dp[i][j] in terms of smaller subproblems.
            Example:
                if(s1[i-1] == s2[j-1]) 
                    dp[i][j] = 1 + dp[i-1][j-1];
                else 
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
        - Iterate and Fill Table: Usually nested loops (for i, for j).
        - Answer Extraction: Solution is often in dp[n][m] or dp[n-1][m-1].




4. 🔹 Java Code Template (General)

            public class TwoDDP {
                public static void main(String[] args) {
                    int n = 5, m = 5; // dimensions
                    int[][] dp = new int[n+1][m+1]; // 2D dp table

                    // Base case initialization
                    for(int i = 0; i <= n; i++) {
                        dp[i][0] = 0; // example base case
                    }
                    for(int j = 0; j <= m; j++) {
                        dp[0][j] = 0; // example base case
                    }

                    // Fill DP table
                    for(int i = 1; i <= n; i++) {
                        for(int j = 1; j <= m; j++) {
                            // Recurrence relation
                            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // example
                        }
                    }

                    // Final answer
                    System.out.println(dp[n][m]);
                }
            }





5. 🔹 Common 2D DP Problems (with Recurrence)
        (a) Minimum Path Sum in Grid
            State: dp[i][j] = min path sum to reach (i,j)
            Recurrence: dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
            Base: dp[0][0] = grid[0][0]

        (b) Longest Common Subsequence (LCS)
            State: dp[i][j] = LCS length of s1[0..i-1] and s2[0..j-1]
            Recurrence:
                if(s1[i-1] == s2[j-1]) 
                    dp[i][j] = 1 + dp[i-1][j-1];
                else 
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            Base: dp[0][*] = 0, dp[*][0] = 0

        (c) 0/1 Knapsack
            State: dp[i][j] = max profit using first i items with capacity j
            Recurrence:
                if(weight[i-1] <= j)
                    dp[i][j] = max(dp[i-1][j], value[i-1] + dp[i-1][j-weight[i-1]]);
                else
                    dp[i][j] = dp[i-1][j];

        (d) Palindrome Partitioning (Substring DP)
            State: dp[i][j] = true if substring s[i..j] is palindrome
            Recurrence:
                if(s[i] == s[j] && (j-i <= 2 || dp[i+1][j-1] == true))
                    dp[i][j] = true;




6. 🔹 Tips to Crack 2D DP
        ✔ Always define what dp[i][j] means before coding.
        ✔ Fill dp table in correct order (row-wise, col-wise, diagonal).
        ✔ Watch for off-by-one errors in indexing.
        ✔ Use long instead of int if values can overflow.
        ✔ Space Optimization: Sometimes you only need the previous row/col → reduce 2D DP to 1D.



        
7. 🔹 Pros and Cons
✅ Pros
    - Simplifies complex recursive solutions
    - Guarantees optimal solution
    - Works well for problems involving 2 constraints/dimensions

❌ Cons
    - High space complexity (O(n×m))
    - Requires careful recurrence definition
    - Debugging can be tricky

👉 In short:
- Identify if two independent states exist.
- Define dp[i][j] clearly.
- Build recurrence carefully.
- Iterate + initialize base cases.
- Answer at dp[n][m].
*/



public class L00_Basic_2d {
    
}