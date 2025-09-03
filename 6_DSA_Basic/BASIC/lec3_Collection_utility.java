

// A class that contains static methods to operate on or return collections (like Lists, Sets, etc.).

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lec3_Collection_utility {
    public static void main(String[] args) {
        
        // sort(List<T> list)  -- sorts the list in natural ascending order 
        List<Integer>nums = Arrays.asList(3 , 5 , 1 , 4) ; 
        Collections.sort(nums) ; 
        System.out.println("printing the sorted list : " + nums) ; 


        // sort(List<T> list , Comparator<T> c) -- Sorts using a custom comparotor 
        List<String>names = Arrays.asList("Ankit" , "Raj" , "Kumar") ; 
        Collections.sort(names, (a, b) -> b.compareTo(a));
        System.out.println("printing the sorted list : " + names); // [Raj, Kumar, Ankit]


        // reverse(List<?> List) -- Reverses the elements in a list 
        Collections.reverse(names);  // [Ankit, Kumar, Raj]
        System.out.println("printing the reverse list : " + names) ; 


        
        // shuffle(List<?> list) -- Randomly shuffles list elements 
        Collections.shuffle(nums);
        System.out.println("printing the shuffle num : " + nums) ; 


        // min(Collection)   --   Returns the minimum element
        int min = Collections.min(nums); // 1\
        System.out.println("printing the minimum num : " + min) ; 

        //max(Collection)  --  Returns the maximum element
        int max = Collections.max(nums); // 5
        System.out.println("printing the maximum num : " + max) ; 


        // frequency(Collection<?> c, Object o) --  Counts how many times o appears in c
        int freq = Collections.frequency(nums, 3);
        System.out.println("3 appears in nums how many times : "+  freq);


        // binarySearch(List<T> list, T key)
        // Searches using binary search
        // Requires the list to be sorted
        List<Integer> sortedList = Arrays.asList(1, 3, 4, 6);
        int index = Collections.binarySearch(sortedList, 4);  // returns 2
        System.out.println("Index at with value" + 4 + " presented : " + index) ;



        // fill(List<T> list, T obj)
        // Fills the list with a repeated object
        Collections.fill(nums, 0); // [0, 0, 0, 0]
        System.out.println("printing the num array : " + nums)  ; 


        // copy (destList , srcList) 
        // copies all elements from src to dest (dest must be of equal or greater size) 
        List<String> dest = Arrays.asList("X", "Y", "Z");
        List<String> src = Arrays.asList("A", "B", "C");
        Collections.copy(dest, src);  // dest becomes [A, B, C]
        System.out.println("printing the dest : " + dest) ; 
        System.out.println("printing the src : " + src) ;


        // replaceAll(List<T> list, T oldVal, T newVal)
        // Replaces all occurrences of oldVal with newVa
        Collections.replaceAll(nums, 0, 1); // replaces all 0s with 1s
        System.out.println("printing the nums : " + nums) ; 



        // sort(T[] array)
        // Sorts array in-place
        int[] arr = {5, 2, 4, 1 , 11};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 4, 5]


        // binarySearch(T[] array, T key)
        // Searches a sorted array for the key
        int idx = Arrays.binarySearch(arr, 4); // returns index 2
        System.out.println("printing idx of 4 : " + idx) ; 
        



    }    
}
