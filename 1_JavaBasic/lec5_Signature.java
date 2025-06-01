

// 📌 Breakdown of Each Part the JVM Requires
// Part	Why Required
// public	JVM must access this method from outside the class
// static	JVM must call it without creating an object
// void	No value should be returned to JVM
// main	Fixed method name for entry
// String[] args	Used to pass command-line arguments

// If you change even one part, the JVM won’t recognize it as the entry point and will throw an error.


// 🧠 Why hardcoded?
// Because the JVM was designed to be:
// Simple and predictable
// Consistent across all Java programs
// Able to find and start execution without needing developers to write extra code


// The JVM is pre-programmed to look for public static void main(String[] args) as the entry point of your Java application. This signature is:
// Mandatory for program execution
// A key part of Java's design philosophy
// Designed for simplicity, predictability, and cross-platform compatibility



public class lec5_Signature {
    public static void main(String[] args) {
        System.out.println("This is the main method with the required signature.");
        System.out.println("You can pass command-line arguments to this program.");
        
        // Example of using args
        if (args.length > 0) {
            System.out.println("Command-line arguments received:");
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("No command-line arguments were provided.");
        }
    }
}
