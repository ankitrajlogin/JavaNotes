

// Top-Level Class vs Nested Class

// Top-Level Class:
// Defined outside any other class.

// // File: MyClass.java
// public class MyClass {
//     // ...
// }
// ✔ Can be public or default (package-private).
// ❌ Cannot be private or protected.





// TYPES OF NESTED CLASSES 

// i. static nested class 
// Like a static member.
// Cannot access instance members of the outer class directly.

class Outer {
    static class StaticNested {
        void msg() {
            System.out.println("Inside static nested class");
        }
    }
}




// (ii) Non-static (Inner) Class
// Has reference to the outer class instance.
// Can access all members of the outer class.

class Outer2 {
    int x = 10;

    class Inner2 {
        void show() {
            System.out.println("the value of class inside the class , x = " + x); // can access outer members
        }
    }
}





// (iii) Local Inner Class
// Defined inside a method or block.
// Cannot use access modifiers (public, private).
// Can access final or effectively final local variables.

class Outer3 {
    void method() {
        int data = 30;
        class Local {
            void msg() {
                System.out.println("this is the message for the local class created : " + data); // effectively final
            }
        }

        Local l = new Local();  // creating object of local class
        l.msg();                // calling method
    }
}



// (iv) Anonymous Inner Class
// A class without a name, defined and instantiated in one go.
// Mostly used for event handling or interface implementation.

// case1 : interface 
interface Greeting {
    void sayHello();
}


// case2 : abstract class 
abstract class Greeting2 {
    abstract void sayHello();
}


// case3 : override to class 
class Greeting3 {
    void sayHello() {
        System.out.println("Hello from base class");
    }
}




public class lec0_class_type {
    public static void main(String[] args) {
        Outer.StaticNested obj = new Outer.StaticNested() ; 
        obj.msg() ; 

        Outer2 outer2 = new Outer2();
        Outer2.Inner2 inner2 = outer2.new Inner2();
        inner2.show();

        Outer3 outer3 = new Outer3(); 
        outer3.method() ; 



        // Anonymous inner classes are a powerful feature in Java for short-lived implementations. They're concise, help reduce code clutter, and are great for single-use logic, especially in event handling or when passing behavior (like callbacks or strategy patterns).

        // from interface
        Greeting g = new Greeting() {
            public void sayHello() {
                System.out.println("Hello from anonymous class extending abstract class!");
            }
        };
        g.sayHello();

        // abstract 
        Greeting2 g2 = new Greeting2(){
            void sayHello(){
                System.out.println("Hello from abstract class") ; 
            }
        };
        g2.sayHello() ; 

        // class overriding
        Greeting3 g3 = new Greeting3(){
            void sayHello(){
                System.out.println("Hello from concrete override") ; 
            }
        };
        g3.sayHello() ; 

    }

    
}




//  Summary of Benefits of @Override:
// ✅ Catches errors early (e.g., wrong method name, wrong signature).
// ✅ Improves readability — makes it clear that a method is overriding.
// ✅ Mandatory if you want safe interface implementation.
// ✅ Helps with code maintenance and collaboration.


