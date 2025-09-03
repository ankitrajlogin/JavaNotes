
// Keywords in Java Inheritance
// | Keyword      | Meaning                                                                 | Use in Inheritance                   |
// | ------------ | ----------------------------------------------------------------------- | ------------------------------------ |
// | `extends`    | Used by a class to inherit from another class                           | Establishes parent-child relation    |
// | `super`      | Refers to the immediate parent class (constructor, method, or variable) | Access parent members                |
// | `this`       | Refers to the current object                                            | Used for method/constructor chaining |
// | `instanceof` | Checks if an object is an instance of a specific class or subclass      | Type checking                        |
// | `final`      | Prevents inheritance or overriding                                      | Secures class/method                 |
// | `abstract`   | Declares an incomplete class or method (must be extended/implemented)   | Creates a contract for subclasses    |


// 1. extends Keyword 
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}




// 2. super Keyword
// Used to:
// Access parent class constructor
// Access parent class methods
// Access parent class variables (when shadowed)

class Parent {
    String name = "Parent";

    void greet() {
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    String name = "Child";

    void display() {
        System.out.println(super.name);  // Access parent's name
        super.greet();                   // Call parent's method
    }
}


// 5. final Keyword
// Used to:
// Prevent a class from being inherited (final class)
// Prevent a method from being overridden (final method)
// Declare a constant variable (final int x = 10;)

class Animal2 {
    final void eat() {
        System.out.println("Eating");
    }
}

class Dog2 extends Animal2 {
    // void eat() {}  ❌ Not allowed, method is final
}



//  6. abstract Keyword
// Used to define:
// Abstract classes: Cannot be instantiated
// Abstract methods: No body, must be implemented in subclass

abstract class Shape {
    abstract void draw(); // must be implemented
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}



// 🔶 Main class
public class lec7_Keywords_in_Inheritance {
    public static void main(String[] args) {
    }
}






