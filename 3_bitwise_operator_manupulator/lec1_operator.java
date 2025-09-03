

// preIncrement -> first change value then use value ; 
// ++ a 

// postIncrement -> first use value then change value ; 
// a++ ; 



// List of Bitwise Operators in Java

// a = 5 → 0101
// b = 3 → 0011

// a & b → 0001 = 1
// a | b → 0111 = 7
// a ^ b → 0110 = 6
// ~a   → 1010 = -6 (in two's complement) not



// ✔ Set/clear/test/toggle ith bit

// // Set ith bit
// n = n | (1 << i);

// // Clear ith bit
// n = n & ~(1 << i);

// // Check ith bit is set or not
// boolean isSet = (n & (1 << i)) != 0;

// toggle bit i 
// n = n ^ (1 << i) ; 


public class lec1_operator {

    public static void main(String args[]){
        int value = 38 ; 


        System.out.println("value after left shift by 1 :" + (value<<1));

        System.out.println("value after right shift by 1 :" + (value>>1)) ;

        System.out.println("value after left shift by 5 :"+(value<<5)) ; 

        System.out.println("value after right shift by 4 :" + (value>>4)) ; 

        System.out.println("value after not of value 38 :" + (~value)) ;



    }
    
}
