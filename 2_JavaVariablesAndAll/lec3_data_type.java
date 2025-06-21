


// 1. Primitive Data Types
// These are the most basic data types built into the language. Java has 8 primitive types:

// | Type      | Size    | Description                                 | Example             |
// | --------- | ------- | ------------------------------------------- | ------------------- |
// | `byte`    | 1 byte  | Stores whole numbers from -128 to 127       | `byte a = 100;`     |
// | `short`   | 2 bytes | Stores whole numbers from -32,768 to 32,767 | `short b = 30000;`  |
// | `int`     | 4 bytes | Stores whole numbers from -2^31 to 2^31-1   | `int c = 100000;`   |
// | `long`    | 8 bytes | Stores very large whole numbers             | `long d = 150000L;` |
// | `float`   | 4 bytes | Stores decimal numbers (single precision)   | `float e = 10.5f;`  |
// | `double`  | 8 bytes | Stores decimal numbers (double precision)   | `double f = 20.99;` |
// | `char`    | 2 bytes | Stores a single character                   | `char g = 'A';`     |
// | `boolean` | 1 bit   | Stores `true` or `false`                    | `boolean h = true;` |






// Class to demonstrate all 8 primitive data types in Java
class PrimitiveExample {
    public static void displayPrimitives() {
        // 1. byte: 1 byte, range -128 to 127
        byte a = 100;

        // 2. short: 2 bytes, range -32,768 to 32,767
        short b = 30000;

        // 3. int: 4 bytes, most commonly used integer type
        int c = 100000;

        // 4. long: 8 bytes, used for large integers. Suffix 'L' is mandatory
        long d = 150000L;

        // 5. float: 4 bytes, single-precision decimal. Suffix 'f' is mandatory
        float e = 10.5f;

        // 6. double: 8 bytes, double-precision decimal
        double f = 20.99;

        // 7. char: 2 bytes, stores a single Unicode character
        char g = 'A';

        // 8. boolean: 1 bit, stores true or false
        boolean h = true;

        // Printing all the values
        System.out.println("byte value      : " + a);
        System.out.println("short value     : " + b);
        System.out.println("int value       : " + c);
        System.out.println("long value      : " + d);
        System.out.println("float value     : " + e);
        System.out.println("double value    : " + f);
        System.out.println("char value      : " + g);
        System.out.println("boolean value   : " + h);
    }
}



class nonPrimitiveExample{  // class 

    public void nonPrimitiveDisplay(){
        String name = "Ankit" ; 
        int[] marks = {90 , 23 , 233} ; // array of integers 

        System.out.println("Name: " + name);
        System.out.print("Marks: ");
        
        for (int mark : marks) {
            System.out.print(mark + " ");
        }

    }    
}



// Main class
public class lec3_data_type {
    public static void main(String[] args) {
        // Call the method from PrimitiveExample class

        System.out.println("\nprimitive Types");
        PrimitiveExample.displayPrimitives();

        System.out.println("\nnon-primitive Types") ;
        nonPrimitiveExample nonPrimitive = new nonPrimitiveExample() ; 

        nonPrimitive.nonPrimitiveDisplay();
    }
}
