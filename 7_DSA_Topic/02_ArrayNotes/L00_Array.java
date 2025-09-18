

/*
-------------------------------
Arrays in JAVA
-------------------------------

1. Introduction
    - An array is a data structure in Java used to store multiple values of the same type in a single variable.
    - Arrays are fixed in size once declared.
    - They store elements in contiguous memory locations for fast access.
    - Each element is accessed by an index (0-based).


2. Array Characteristics
    - Fixed size (cannot grow/shrink).
    - Homogeneous (same data type).
    - Index-based access.
    - Stored in heap memory.
    - Default values:
        - int → 0
        - float → 0.0
        - boolean → false
        - object reference → null

 */

import java.util.Arrays;

class Array{
    // a) Single-Dimensional Array
    // Stores data in a single row (linear form).

    public void SingleDimensionArray(){
        int[] arr = new int[5];

    }


    // (b) Multi-Dimensional Array
    // Array of arrays.
    // Most common is 2D array (like a matrix).

    public void MultiDimensionalArray(){
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
    }


    // (c) Jagged Array
    // An array of arrays with different column sizes.

    public void JaggedArray(){
        int[][] jagged = new int[3][];
        jagged[0] = new int[2]; 
        jagged[1] = new int[4]; 
        jagged[2] = new int[3];
    }


}

public class L00_Array{
    public static void main(String[] args){
        // Declaration
        int[] arr;
        int arr2[];   // both valid

        // Memory Allocation
        arr = new int[5];   // array of size 5, default values = 0

        // Declaration + Allocation
        int[] arr23 = new int[5];

        // Declaration + Initialization
        int[] arr3 = {10, 20, 30, 40, 50};


        System.out.println("First element: " + arr3[0]);
        System.out.println("Length: " + arr3.length);



        int[] array = {5, 3, 1, 4, 2};
        
        Arrays.sort(array);   // Sorting
        System.out.println(Arrays.toString(array));

        int index = Arrays.binarySearch(array, 4);  // Binary Search
        System.out.println("Index of 4: " + index);

        int[] copy = Arrays.copyOf(array, array.length); // Copy
        System.out.println(Arrays.equals(array, copy)); // Compare

    }
}