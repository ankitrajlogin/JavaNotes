import java.util.Arrays;

//  What is String[] args?
// String[] means: an array of String type
// args is just the name of the variable (you can call it anything like input, arguments, etc.)
// This whole part — String[] args — is how Java receives input from the command line when you run the program.


// Why do we need to write String[] args?
// Because when Java runs your program, the Java Virtual Machine (JVM) needs a starting point, and it calls this exact method:
// public static void main(String[] args)
// If you don’t write it like this, the JVM won’t know how to start your program.
// It’s a special method signature the JVM expects.


// What is the use of args?
// It lets you pass values from the command line when running the program.
// 🔸 Example:
// Run this:
// java lec4_args Hello Ankit 123

// code
// System.out.println(args[0]); // Hello
// System.out.println(args[1]); // Ankit
// System.out.println(args[2]); // 123
// So args gives you a way to take dynamic input when the program starts — without using Scanner or GUI.



// 🔹 What if we remove String[] args?
// java
// Copy code
// public static void main() {
// }
// ✅ It will compile.
// ❌ But when you run it, JVM gives an error:
// javascript
// Copy code
// Error: Main method not found in class lec4_args...
// Because JVM looks for this exact signature.






public class lec4_args {
     public static void main(String[] args) {
        System.out.println("Java vs C++ Compilation and Execution");

        // Print the full array of arguments
        System.out.println("Command-line arguments as array:");
        System.out.println(Arrays.toString(args));

        // Print each argument separately
        System.out.println("Each argument on a new line:");
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}


// ❓ Why does the JVM look for this exact signature?
// Because it’s hardcoded into the design of the Java language and the Java Virtual Machine (JVM). It’s like a contract between your program and the JVM.

// JVM’s Contract (Entry Point Rule)
// When you run a Java class using:
// java MyClass
// The JVM searches for a method with this exact signature:
// public static void main(String[] args)
// This method acts as the starting point of your application.

