

// What is a Constructor?
// A constructor in Java is a special method that is called automatically when an object is created.

// It is used to initialize the object — that means to assign initial values to its fields (variables).



// What is a Private Constructor?
// A private constructor is a constructor that cannot be accessed from outside the class.

// 🔒 Use Cases:
// Prevent object creation from outside
// Implement Singleton Pattern
// Make utility classes (like Math, Collections) non-instantiable
// Use in Factory Pattern to control instance creation





class Singleton { // Removed 'public'
    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton constructor called");
    }

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();

        System.out.println("class called : " + instance);
        return instance;
    }
}

public class lec5_private_constructor {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        System.out.println(obj1 == obj2); // true
    }
}


// Why we declare private static Singleton instance;
// Feature -> 	Reason
// private -> No one can access or modify the instance directly
// static ->	Shared across all usages of the class — only one instance exists
// Singleton type ->	The variable stores the Singleton object itself



// Bonus: You are using a class as a type inside itself
// Yes! Singleton is the name of the class, and also being used as a data type inside the class:

// This is perfectly valid in Java — a class can contain variables or methods that use its own type.

// This is commonly done in:
// Recursive structures (like linked lists or trees)
// Singleton pattern
// Copy constructors
// Fluent APIs (returning this)