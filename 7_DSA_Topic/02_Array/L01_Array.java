

/*
-------------------------------
Arrays in JAVA
-------------------------------

1. Introduction
    - An array is a data structure in Java used to store multiple values of the same type in a single variable.
    - Arrays are fixed in size once declared.
    - They store elements in contiguous memory locations for fast access.
    - Each element is accessed by an index (0-based).

 */

public class L01_Array{
    public static void main(String[] args){
        // Declaration
        int[] arr;
        int arr[];   // both valid

        // Memory Allocation
        arr = new int[5];   // array of size 5, default values = 0

        // Declaration + Allocation
        int[] arr2 = new int[5];

        // Declaration + Initialization
        int[] arr3 = {10, 20, 30, 40, 50};


        System.out.println("First element: " + arr3[0]);
        System.out.println("Length: " + arr3.length);

    }
}