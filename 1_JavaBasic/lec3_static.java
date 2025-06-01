
// What does static mean in Java?
// In Java, the keyword static means “belonging to the class, not to any specific object”.
// So, when something is declared as static, it can be accessed without creating an object of the class.
// This is particularly useful for methods that need to be called without needing an instance of the class.


// Why is the main() method static in Java?
// public static void main(String[] args)
// This is the entry point of your program. It’s where the JVM starts execution.

// But here's the key:
// When the JVM wants to start your program, it doesn’t create an object of your class. It simply calls the main() method directly.
// That’s why main() must be static.


// If main() were not static, the JVM would need to create an instance of your class first, which it cannot do because it doesn't know how to do that without a main method.
// So, the main() method must be static to allow the JVM to call it without creating an instance of the class first.
// This is why the main() method is always declared as static in Java programs.

// In summary, the static keyword allows the main method to be called by the JVM without needing to create an instance of the class first.


public class lec3_static {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("This is a static method in Java.");
        // You can call other static methods from here if needed.
    }
    
}
