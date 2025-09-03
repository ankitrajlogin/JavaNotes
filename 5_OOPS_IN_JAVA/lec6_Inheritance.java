
// Inheritance is the process where one class (child/subclass) acquires properties and behaviors (fields and methods) of another class (parent/superclass).

// It allows:
// Code reusability
// Method overriding for custom behavior
// Polymorphism (especially runtime)


// Types of Inheritance in Java
// | Type             | Supported in Java? | Example                              |
// | ---------------- | ------------------ | ------------------------------------ |
// | **Single**       | ✅ Yes              | One subclass inherits one superclass |
// | **Multilevel**   | ✅ Yes              | Class A → B → C                      |
// | **Hierarchical** | ✅ Yes              | One parent, multiple children        |
// | **Multiple**     | ❌ (with classes)   | Java avoids diamond problem          |
// | **Hybrid**       | ❌ (with classes)   | But possible via interfaces          |



// multilevel inheritance. 
class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("barking...");
    }
}

class Puppy extends Dog {
    void weep() {
        System.out.println("weeping...");
    }
}


// Hierarchical Inheritance 

class Car{
    void tier(){
        System.out.println("Car have four tier");
    }
}

class Mercides{
    void Price(){
        System.out.println("Expensive car") ; 
    }
}

class alto{
    void Price(){
        System.out.println("Lower Price car") ; 
    }
}



public class lec6_Inheritance {

    public static void main(String[] args) {
        Puppy pup = new Puppy() ; 
        pup.weep();
        pup.bark();
        pup.eat() ;


        Animal pup2 = new Puppy() ; 
        pup2.eat();       // ✅ Valid – from Animal class
        // pup2.bark();      // ❌ Compile-time error – not accessible
        // pup2.weep();      // ❌ Compile-time error – not accessible

    }
    
}


// 1. Puppy pup = new Puppy();
// This is normal object creation — you're creating a Puppy object and referring to it using a reference of type Puppy.
// 🔍 What happens here:
// Both object type and reference type are Puppy.
// You can access all methods from Puppy, Dog, and Animal because Puppy is a subclass of both.

// pup.weep();  // From Puppy
// pup.bark();  // From Dog
// pup.eat();   // From Animal




// 2. Animal pup = new Puppy();
// This is an example of upcasting — you're creating a Puppy object, but referencing it with the superclass (Animal).

// 🔍 What happens here:
// Object type = Puppy
// Reference type = Animal
// You can access only the methods available in the Animal class, not the overridden or child-specific methods unless you use type casting.




// Why is this useful?
// Because Java supports dynamic method dispatch (runtime polymorphism):

// Animal a = new Puppy();
// a.eat();  // Calls Animal’s eat() unless overridden in Puppy
// If Puppy had overridden the eat() method, then Puppy's version would be called, even though the reference is of type Animal.


// SUMMARY : 
// | Code                        | Access to Methods From            | Use Case                   |
// | --------------------------- | --------------------------------- | -------------------------- |
// | `Puppy pup = new Puppy();`  | `Puppy`, `Dog`, `Animal`          | Full access                |
// | `Animal pup = new Puppy();` | Only `Animal` (unless overridden) | Polymorphism / abstraction |
