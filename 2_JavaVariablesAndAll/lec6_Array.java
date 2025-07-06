
// Array Types in Java
// 1. One-Dimensional Array – simple list
// 2. Multi-Dimensional Array – e.g., 2D matrix
// 3. Jagged Array – array of arrays with different sizes



public class lec6_Array{
    public static void main(String arg[]){
        // 1D array 
        int[] arr1 = new int[5] ; // allocates memory , default values 0 
        int[] arr2 = {1 , 2, 3, 4, 5} ; // direct initialization 

        System.out.println(arr1[0]) ; 
        System.out.println(arr2[0]) ; 


        // 2D array 
        int[][] matrix = new int[3][3];  // 3x3 matrix
        int[][] matrix2 = {
            {1, 2},
            {3, 4}
        };

        System.out.println(matrix[0][0]) ; 
        System.out.println(matrix2[0][0]) ; 



        // Jagged Array ; 

        int[][] jagged = new int[3][] ; 
        // This creates a jagged (irregular) 2D array with 3 rows, but the columns (inner arrays) are not yet defined.
        // Can you insert values without defining the inner arrays first?
        // No, you cannot.   
        // jagged[0][1] = 213 ; 
        // Because while jagged[0], jagged[1], and jagged[2] exist as null references, they don’t point to actual arrays yet.

        // Now define the inner arrays with different lengths
        jagged[0] = new int[2];  // 2 columns
        jagged[1] = new int[4];  // 4 columns
        jagged[2] = new int[3];  // 3 columns

        // Now you can assign values
        jagged[0][0] = 10;
        jagged[0][1] = 20;


        System.out.println(jagged[0][1]);



        // Arrays use .length as a field
        System.out.println(jagged.length);        // 3 (number of rows)
        System.out.println(jagged[0].length);     // 2
        System.out.println(jagged[1].length);     // 4
        System.out.println(jagged[2].length);     // 3

        
  

    }
}
