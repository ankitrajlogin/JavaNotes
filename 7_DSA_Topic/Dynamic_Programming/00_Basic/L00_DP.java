
/*

------------------------------------------------------
Dynamic Programming (DP) – Complete Notes
------------------------------------------------------


🔹 1. What is Dynamic Programming?
    - Definition: A technique to solve complex problems by breaking them down into simpler overlapping subproblems and storing their solutions (so each subproblem is solved only once).
    - It’s an optimization over recursion.
    - DP = Divide & Conquer + Memoization.
    - Key Idea: If a problem has overlapping subproblems and optimal substructure, we can apply DP.

🔹 2. Key Properties (When to use DP?)
    Optimal Substructure
        A problem has optimal substructure if its optimal solution can be constructed from optimal solutions of subproblems.
        Example: Shortest path, Fibonacci.

    Overlapping Subproblems
        A problem has overlapping subproblems if solving it involves solving the same subproblem multiple times.
        Example: Fibonacci recursion recalculates fib(2) many times.


🔹 3. Approaches in DP
    There are mainly two approaches:

    (a) Top-Down (Memoization)
        Recursion + cache (store results in dp[] when first calculated).
        Avoids recomputation.
        Example:
            int fib(int n, int[] dp) {
                if (n <= 1) return n;
                if (dp[n] != -1) return dp[n]; // already computed
                return dp[n] = fib(n-1, dp) + fib(n-2, dp);
            }

    (b) Bottom-Up (Tabulation)
        Iterative, fills a DP table from base cases → final result.
        Saves recursion overhead.
        Example:
            int fib(int n) {
                int[] dp = new int[n+1];
                dp[0] = 0; dp[1] = 1;
                for (int i=2; i<=n; i++) {
                    dp[i] = dp[i-1] + dp[i-2];
                }
                return dp[n];
            }



🔹 4. Steps to Solve a DP Problem
    Identify if it’s DP → check for optimal substructure & overlapping subproblems.

    Define State → dp[i] or dp[i][j] (what does it represent?).
    Example: dp[i] = max profit till index i.

    Form Recurrence Relation → relation between current state & smaller subproblems.
    Example: dp[i] = max(dp[i-1], price[i] + dp[i-2]).

    Base Cases → smallest subproblems.
    Example: dp[0] = arr[0].

    Order of Computation → top-down (recursive) or bottom-up (iterative).

    Answer → dp[n-1] (or some max/min over dp table).




🔹 5. Types of DP Problems
        1. 1D DP
            State depends on 1 variable.
            Examples:
                - Fibonacci numbers
                - Climbing stairs
                - House Robber

        2. 2D DP (Matrix / Grid problems)
            State depends on 2 variables.
            Examples:
                - Longest Common Subsequence (LCS)
                - Edit Distance
                - Matrix Chain Multiplication
                - Unique Paths in grid

        3. DP on Subsequences
            Pick / Not pick choices.
            Examples:
                - Subset Sum
                - Knapsack problem
                - Partition Equal Subset Sum

        4. DP on Strings
            Comparing two strings.
            Examples:
                - LCS
                - Longest Palindromic Subsequence
                - Edit Distance

        5. DP on Trees/Graphs
            Solve recursively for child nodes.
            Examples:
                - Diameter of Binary Tree
                - Tree DP (max path sum)

        6. Bitmask DP
            State represented using bitmask (good for subsets/permutations).
            Examples:
                - Traveling Salesman Problem (TSP)
                - Counting subsets with given property

        7. DP with Space Optimization
            Sometimes we don’t need the whole DP table → only last few states.
            Examples:
                - Fibonacci with O(1) space.
                - LCS optimized from O(n*m) to O(min(n, m)) space.


🔹 6. Common Examples
        1. Fibonacci (basic DP intro)
            - Recursive → exponential
            - DP → O(n)
        
        2. Climbing Stairs
            - ways[i] = ways[i-1] + ways[i-2]
        
        3. Knapsack Problem (0/1 Knapsack)
            - dp[i][w] = max(value[i-1] + dp[i-1][w-wt[i-1]], dp[i-1][w])
        
        4. Longest Common Subsequence (LCS)
            - dp[i][j] = 1 + dp[i-1][j-1] if s1[i-1]==s2[j-1] else max(dp[i-1][j], dp[i][j-1])
        
        5. Coin Change
            - dp[amount] = min(dp[amount-coin] + 1) over all coins



🔹 7. Pros & Cons
    ✅ Pros:
        Efficient (avoids recomputation).
        Reduces exponential recursion to polynomial time.
        Widely applicable (arrays, strings, graphs, optimization problems).

    ❌ Cons:
        Requires problem recognition (not always obvious).
        DP tables may need large memory.
        Implementation can be tricky (especially multidimensional DP).

🔹 8. Applications of DP

        - Computer Science:
            - Parsing, text comparison (edit distance)
            - Compilers, AI search
            - Graph algorithms (Floyd-Warshall)

        - Operations Research:
            - Resource allocation
            - Scheduling

        - Competitive Programming:
            - Classic DP problems (Knapsack, LCS, LIS, Matrix paths)

        - Machine Learning:
            - Hidden Markov Models (HMMs)
            - Reinforcement learning (value iteration, policy iteration)




🔹 9. Tips for Mastering DP
    - Always write recurrence relation first before coding.
    - Start with small problems (Fibonacci, Climbing Stairs).
    - Gradually move to Knapsack, LCS, Matrix problems.
    - Practice pattern-based learning:
        - Subsequence → Knapsack style
        - Strings → LCS style
        - Grid → Path style
    - Focus on state definition → that’s the toughest but most important part.



🔹 10. Summary
        - DP = recursion + memory.
        - Two approaches: Top-Down (Memoization), Bottom-Up (Tabulation).
        - Steps: Define State → Recurrence → Base Case → Compute → Answer.
        - Categories: 1D, 2D, Subsequence, String, Tree/Graph, Bitmask.
        - DP transforms exponential recursion into polynomial-time solutions.
*/

public class L00_DP {
    
}
