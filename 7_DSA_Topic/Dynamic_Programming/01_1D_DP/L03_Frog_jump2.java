

/*

Problem Statement: Frog Jump II (LeetCode 2498)

You are given a 0-indexed integer array stones of length n, sorted in strictly increasing order, where each element represents the position of a stone in a river.
    - A frog starts on the first stone (stones[0] = 0) and wants to travel to the last stone (stones[n-1]) and then return back to the first stone.
    
    - The frog can visit each stone at most once.
    
    - The length of a jump is the absolute difference between the positions of the stone the frog jumps from and the stone it jumps to.
    
    - The cost of a path is the maximum jump length in that path.
    
Your task is to return the minimum possible cost of a valid path.

 */

/*
--------------------------------
Solution 
--------------------------------
At first it look like DP problem , but letter we realise it simple logical problem. 


✅ Solution Explanation

The frog must cover all stones exactly once (forward and backward trip).
The optimal strategy is:
    - On the way forward, skip every other stone.
    - On the way back, visit the skipped stones.
    - This guarantees that no jump is unnecessarily large.

Therefore, the answer is:
    - The maximum difference between stones[i] and stones[i-2] for all i >= 2.
    - Also consider edge jumps (stones[1] - stones[0] and stones[n-1] - stones[n-2]).

This works in O(n) time and O(1) extra space.

*/

class FrogJumpII {

    /**
     * Function to calculate the minimum cost of the frog's path.
     * @param stones array of stone positions (sorted, increasing)
     * @return minimum possible cost of the path
     */
    public int maxJump(int[] stones) {
        int n = stones.length;
        int answer = 0;

        // Check jumps by skipping one stone (i vs i-2)
        for (int i = 2; i < n; i++) {
            answer = Math.max(answer, stones[i] - stones[i - 2]);
        }

        // Edge cases: first and last stone jumps
        answer = Math.max(answer, stones[1] - stones[0]);
        // answer = Math.max(answer, stones[n - 1] - stones[n - 2]); not need as we already calculated stones[n-1] - stones[n-3] which is always greater than this calculation 

        return answer;
    
    }

    public int maxJumpOptimize(int[] stones){

        int n = stones.length ; 
        int answer = 0 ; 

        int prev_val = stones[0] ;
        int curr_val = stones[1] ; 

        answer = curr_val-prev_val ; 

        for(int i = 2 ; i< n ; i++){
            answer = Math.max(answer , stones[i] - stones[i-2])  ; 
        }

        return answer ; 

    }

    // Main method with test cases
    
}

public class L03_Frog_jump2 {
    public static void main(String[] args) {
        FrogJumpII solution = new FrogJumpII();

        int[] stones1 = {0, 2, 5, 6, 7};
        int[] stones2 = {0, 3, 9};

        System.out.println("Test case 1:");
        System.out.println("Input: [0, 2, 5, 6, 7]");
        System.out.println("Output: " + solution.maxJump(stones1)); // Expected 5
        System.out.println("Output: " + solution.maxJumpOptimize(stones1)); // Expected 5

        System.out.println("\nTest case 2:");
        System.out.println("Input: [0, 3, 9]");
        System.out.println("Output: " + solution.maxJump(stones2)); // Expected 9
        System.out.println("Output: " + solution.maxJumpOptimize(stones2)); // Expected 9
    }
}
