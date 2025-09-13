
/*
Problem Recap
    - You’re given an array nums of size n.
    - A majority element is an element that appears more than ⌊n/2⌋ times.
    - The problem guarantees that such an element always exists.



Boyer-Moore Voting Algorithm (Explanation)
    The idea:
        1. Keep a candidate element (value) and a counter (count).
        2. Iterate over the array:
                - If count == 0, set value to the current element and reset count = 1.
                - If the current element equals value, increment count.
                - Otherwise, decrement count.
        3. At the end, value will hold the majority element.

        
Why does this work?
Because the majority element occurs more than half the time, it will always remain as the last valid candidate after all "cancellations" between majority and minority elements.
 */

public class Q02_Majority_Element {
    public static int majorityElement(int[] nums){
        int count = 0 ; 
        int value = 0 ; 

        for(int num : nums){
            if(count == 0){
                value = num ; 
                count = 1 ; 
            }
            else if(num == value){
                count++ ; 
            }
            else{
                count-- ; 
            }
        }

        return value ; 
    }


    public static void main(String[] args){
        int[] nums = {1 , 2, 1, 1, 2 ,3 } ; 

        int majorityValue = majorityElement(nums) ; 

        System.out.println("Majority element is : " + majorityValue) ; 

    }
}
