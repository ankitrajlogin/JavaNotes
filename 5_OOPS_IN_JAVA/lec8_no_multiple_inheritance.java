

// Multiple Inheritance means a class can inherit properties and behaviors (methods) from more than one parent.

// Why Multiple Inheritance (Classes) is Not Supported?
// Java avoids diamond problem caused by multiple inheritance of classes.


// ☕ Java designers intentionally avoided multiple inheritance with classes to:
// Reason ->	Explanation
// Avoid ambiguity	Like the diamond problem shown above
// Simplicity	Cleaner object model and simpler inheritance chain
// Readability	Easier to read/maintain class hierarchies
// Reliability	Prevent bugs caused by conflicting inherited methods or fields




// Java's Alternative: Multiple Inheritance via Interfaces
// Java supports multiple inheritance using interfaces, not classes.

interface A {
    void show();
}

interface B {
    void show();
}

class C implements A, B {
    public void show() {
        System.out.println("Implemented show()");
    }
}

// No ambiguity here, because:
// Interfaces have no method body (till Java 7)
// The class must override and implement the method, so there’s only one definition


// Since Java 8: default methods in interfaces

interface E {
    default void show() { System.out.println("A"); }
}

interface F {
    default void show() { System.out.println("B"); }
}

class G implements E, F {
    public void show() {
        E.super.show(); // Explicitly resolve conflict
    }
}
// Even when methods have bodies, Java forces you to resolve the conflict — no ambiguity.

public class lec8_no_multiple_inheritance {

    public static void main(String[] args) {
        
    }
}