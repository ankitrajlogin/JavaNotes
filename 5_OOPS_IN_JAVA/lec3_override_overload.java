
// What is Method Overriding?
// Overriding means providing a new version of a method in a subclass that is already defined in its superclass.

// Used in inheritance
// Achieves runtime polymorphism
// Signature (name + parameters) must be exactly same


// 2. What is Method Overloading?
// Overloading means having multiple methods in the same class with the same name, but different parameter lists.

// Used in the same class
// Achieves compile-time polymorphism
// Return type can vary, but signature must differ (parameters)




// function overriding 
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}


// function overloading ; 


class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}




public class lec3_override_overload {

    public static void main(String[] arg){

        Animal a = new Animal() ; 
        a.sound() ; 

        Animal b = new Dog() ; 
        b.sound() ; 





        Calculator c = new Calculator();
        System.out.println(c.add(2, 3));       // 5
        System.out.println(c.add(2.5, 3.1));   // 5.6
        System.out.println(c.add(1, 2, 3));    // 6

    }
    
    
}



// | Feature                   | **Overriding**                                | **Overloading**                             |
// | ------------------------- | --------------------------------------------- | ------------------------------------------- |
// | **Location**              | Different classes (Parent–Child relationship) | Same class                                  |
// | **Inheritance required?** | ✅ Yes                                         | ❌ No                                        |
// | **Method signature**      | Must be exactly the same                      | Must be different (type or count of params) |
// | **Return type**           | Must be same (or covariant)                   | Can be different                            |
// | **Polymorphism type**     | Runtime polymorphism                          | Compile-time polymorphism                   |
// | **Annotation used?**      | `@Override` is recommended                    | ❌ Not used                                  |
// | **Binding**               | Dynamic (Late binding)                        | Static (Early binding)                      |
// | **Purpose**               | To change or extend base class behavior       | To provide multiple ways to call a method   |

