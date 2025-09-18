

/*


----------------------------------------------------
Bitwise Manipulation in Java – Complete Notes
----------------------------------------------------


🔹 1. What is Bitwise Manipulation?
    - Bitwise manipulation means working directly on binary bits (0s and 1s) of integers.
    - Faster than arithmetic operations because it works at the CPU instruction level.
    - Very useful in:
        - Competitive programming
        - Optimizations
        - Cryptography
        - Low-level hardware interactions
        - Solving DSA problems (subsets, masks, unique numbers, etc.)


🔹 2. Bitwise Operators in Java
    - Java provides 6 main bitwise operators:

| Operator             | Symbol | Description                                   | Example                         |     |         |
| -------------------- | ------ | --------------------------------------------- | ------------------------------- | --- | ------- |
| AND                  | `&`    | Bit is `1` only if both bits are `1`          | `5 & 3 = 1`                     |     |         |
| OR                   |  `     |  `                                            | Bit is `1` if either bit is `1` |     |         |
| XOR                  | `^`    | Bit is `1` if bits are different              | `5 ^ 3 = 6`                     |     |         |
| NOT                  | `~`    | Inverts all bits                              | `~5 = -6`                       |     |         |
| Left Shift           | `<<`   | Shifts bits left (multiply by 2^n)            | `5 << 1 = 10`                   |     |         |
| Right Shift (Signed) | `>>`   | Shifts bits right (divide by 2^n, keeps sign) | `-8 >> 2 = -2`                  |     |         |
| Unsigned Right Shift | `>>>`  | Shifts bits right, fills with 0               | `-8 >>> 2 = large positive`     |     |         |





preIncrement -> first change value then use value ; 
++ a 

postIncrement -> first use value then change value ; 
a++ ; 



List of Bitwise Operators in Java

a = 5 → 0101
b = 3 → 0011

a & b → 0001 = 1
a | b → 0111 = 7
a ^ b → 0110 = 6
~a   → 1010 = -6 (in two's complement) not



✔ Set/clear/test/toggle ith bit

// Set ith bit
n = n | (1 << i);

// Clear ith bit
n = n & ~(1 << i);

// Check ith bit is set or not
boolean isSet = (n & (1 << i)) != 0;

toggle bit i 
n = n ^ (1 << i) ; 

 */



public class lec00_Bitwise {
    
    public static void main(String args[]){
        int value = 38 ; 


        System.out.println("value after left shift by 1 :" + (value<<1));

        System.out.println("value after right shift by 1 :" + (value>>1)) ;

        System.out.println("value after left shift by 5 :"+(value<<5)) ; 

        System.out.println("value after right shift by 4 :" + (value>>4)) ; 

        System.out.println("value after not of value 38 :" + (~value)) ;



    }
}
