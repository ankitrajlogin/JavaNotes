

// Problem with String 
// Strings in Java are immutable.
// Every time you modify a String (like concatenation), a new object is created.



// StringBuilder is mutable
// It modifies the same object in memory without creating new ones.
// It's optimized for appending, inserting, or deleting characters.


public class lec8_String_Builder {

    public static void main(String arg[]){

    
        String s = "Ankit";
        s = s + "Raj"; // creates a new String object "AnkitRaj"

        // This leads to memory overhead and performance issues, especially in loops or when modifying large strings.


        // StringBuilder
        // StringBuilder is a mutable sequence of characters.
        // It allows you to modify strings in-place without creating new objects.
        // It’s in the java.lang package (no import needed).

        StringBuilder sb = new StringBuilder("Ankit") ; 
        System.out.println("Final String: " + sb.toString());

        sb.append(" Raj");               // Add at end
        System.out.println("Final String: " + sb.toString());

        sb.insert(0, "Mr. ");            // Insert at beginning
        System.out.println("Final String: " + sb.toString());

        sb.replace(0, 3, "The Dr.");         // Replace "Mr." with "Dr."
        System.out.println("Final String: " + sb.toString());

        sb.delete(4, 5);                 // Remove extra space
        System.out.println("Final String: " + sb.toString());

        sb.setCharAt(3, '_');            // Change character at index 3
        System.out.println("Final String: " + sb.toString());

        sb.reverse();                    // Reverse the string
        System.out.println("Final String: " + sb.toString());


        // But 
        // StringBuilder is not Thread-safe. for thread-safe , we can use stringbuffer. 

        // Thread-safe means that multiple threads can access or modify a piece of code at the same time without causing data corruption or unexpected behavior.

    }
}
