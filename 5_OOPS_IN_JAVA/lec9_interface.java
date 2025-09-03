


// public class lec9_interference {
//     ✅ What is an Interface in Java?
// An interface in Java is a contract. It tells the class what methods it must implement, without saying how.

// It's a reference type, similar to a class, but:

// It only contains method signatures (before Java 8).

// It cannot have method bodies (until Java 8).

// It is used for abstraction and multiple inheritance.

// 🧠 Why Use an Interface?
// Even if a class exists, we might want an interface because:

// 🔄 Multiple Inheritance – Java does not support multiple inheritance with classes, but a class can implement multiple interfaces.

// 🔄 Loose Coupling – You can write flexible and scalable code. The code is independent of implementation.

// 🔄 Polymorphism – An object can be referred to by its interface type.

// 🧪 Testability – Easier to mock interfaces in unit testing.






// Class Already Exists. Why Interface Then?
// Let’s say you already have a class Dog, Cat, Lion. But now you want to ensure all of them support the same behavior — say, makeSound(). You can’t make them extend each other, because Java doesn’t support multiple inheritance with classes.

import java.lang.reflect.Method;
import java.security.Key;

interface Sound {
    void makeSound();
}

class Dog implements Sound {
    public void makeSound() {
        System.out.println("Bark");
    }
}

class Cat implements Sound {
    public void makeSound() {
        System.out.println("Meow");
    }
}

public class lec9_interface {

    public static void main(String[] args) {
        
    }
}



// Key Differences Between Abstract Class and Interface

// | Feature                  | Abstract Class                         | Interface                                   |
// | ------------------------ | -------------------------------------- | ------------------------------------------- |
// | **Keyword Used**         | `abstract class`                       | `interface`                                 |
// | **Method Types**         | Abstract + Concrete                    | Abstract (default/static from Java 8)       |
// | **Constructor**          | Yes                                    | No                                          |
// | **Multiple Inheritance** | Not supported                          | Supported (via implementation)              |
// | **Access Modifiers**     | Can be private, protected, public      | All methods are public by default           |
// | **Fields/Variables**     | Can have instance and static variables | Only public static final (constants)        |
// | **Purpose**              | Partial abstraction + code reuse       | Full abstraction + design contract          |
// | **Instantiation**        | Cannot instantiate                     | Cannot instantiate                          |
// | **Inheritance Type**     | Extend only one abstract class         | Implement multiple interfaces               |
// | **Speed/Performance**    | Faster (due to method implementation)  | Slightly slower (no method body by default) |
