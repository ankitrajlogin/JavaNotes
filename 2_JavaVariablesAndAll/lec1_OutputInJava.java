

public class lec1_OutputInJava{
    
    public static void main(String[] args){
        System.out.println("This is a new line."); // Prints with a newline
        System.out.print("Hello, World! ") ; // Prints without a newline
        System.out.print("This is on the same line."); // Continues on the same line
        
    }
}



// 1. System
// Belongs to the java.lang package (automatically imported).
// It is a utility class that provides access to system-level resources.
// It contains several useful members like in, out, and err.

// 2. out
// out is a static final PrintStream object.
// It represents the standard output stream (i.e., your console).
// It's initialized to point to the console by default.
// Since it's static, you can access it directly using System.out.

// 3. print() and println()
// These are methods of PrintStream class.
// print() prints the text without a new line.
// println() prints the text and then adds a new line.


// In Summary
// Use the System class,
// Access its static out object (which is a PrintStream connected to the console),
// Call the print() method to send text to the output stream.

