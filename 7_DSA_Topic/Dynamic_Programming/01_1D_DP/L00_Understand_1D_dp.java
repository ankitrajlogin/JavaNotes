


/*
Understanding 1D Dynamic Programming (DP)
-----------------------------------------

🔹 1. What is 1D DP?
A DP problem is 1D when the state depends on only one variable (usually an index, step, or size).
The solution can be stored in a 1D array dp[i], where i represents:
    - Position in the array/string
    - Step number
    - Value up to some limit

Recurrence typically looks like:
    dp[i] = function(dp[i-1], dp[i-2], …)



🔹 2. Key Signs a Problem is 1D DP
    - The decision at position i is based only on smaller indices.
        Example: Fibonacci → dp[i] = dp[i-1] + dp[i-2]
    - Each state has a single dimension of dependency (like "till index i").
        Example: House Robber → dp[i] = max(dp[i-1], dp[i-2] + nums[i])
    - Only one variable (length, index, step) is needed to describe subproblems.
        Example: Climbing Stairs → ways[i] = ways[i-1] + ways[i-2]
    - Recursion calls have only one changing parameter.
        Example: f(n) = f(n-1) + f(n-2) → 1D




🔹 3. Typical Examples of 1D DP

| Problem                      | State Definition                  | Recurrence                                    |
|------------------------------|-----------------------------------|-----------------------------------------------|
| Fibonacci                    | dp[i] = i-th Fibonacci            | dp[i] = dp[i-1] + dp[i-2]                     |
| Climbing Stairs              | dp[i] = ways to reach i-th stair  | dp[i] = dp[i-1] + dp[i-2]                     |
| House Robber                 | dp[i] = max loot till house i     | dp[i] = max(dp[i-1], dp[i-2] + nums[i])       |
| Maximum Subarray (Kadane’s)  | dp[i] = max sum subarray at i     | dp[i] = max(arr[i], dp[i-1] + arr[i])         |
| Longest Increasing Subseq.   | dp[i] = LIS ending at i           | dp[i] = 1 + max(dp[j]) for j<i & arr[j]<arr[i]|



🔹 4. How to Recognize in Practice
- Ask: "Can I describe the subproblem with only one variable?"
    If yes → likely 1D DP.
    If two variables needed (like i & j in strings/grids) → 2D DP.
- Try recursion first:
    If recursion looks like f(i) → 1D DP.
    If recursion looks like f(i, j) → 2D DP.
- Look at constraints:
    If input is a single array/number → likely 1D DP.
    If input is two arrays/strings/matrix → likely 2D DP.



🔹 5. Space Optimization
Most 1D DP problems allow O(1) space optimization, because you only need the last 1–2 states.
Example: Fibonacci → instead of full dp[], just store prev1, prev2.



🔹 6. Additional Details & Tips
- Base cases are crucial: Always define dp[0], dp[1] etc. clearly.
- Many interview problems are disguised 1D DP (e.g., jump game, min cost climbing stairs).
- Sometimes, greedy solutions work for 1D DP, but DP is more general.
- For optimization, analyze if you can overwrite the dp array or use variables.
- Practice converting recursive solutions to iterative DP for efficiency.



🔹 7. Summary
- 1D DP state = depends on one variable (index, step, size).
- Recurrence uses smaller indices from the same dimension.
- Problems: Fibonacci, Climbing Stairs, House Robber, Kadane’s, LIS.
- Recognition trick: Try recursion; if function has one parameter → 1D DP.
*/

public class L00_Understand_1D_dp {
    
}

