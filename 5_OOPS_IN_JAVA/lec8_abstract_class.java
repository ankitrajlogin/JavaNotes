


// An abstract class in Java:
// Is a class declared with the abstract keyword.
// May contain abstract methods (methods with no body).
// Is incomplete on its own and needs a subclass to be complete.
// Cannot be used to create objects directly.



// NOTE :                                              
// | -------------------------------------------------------- 
// | ✅ Abstract method → requires abstract class
// | ❌ Concrete (normal) class → cannot have abstract methods 
// | ✅ Abstract class → may or may not have abstract methods  


// | Concept                | Explanation                              |
// | ---------------------- | ---------------------------------------- |
// | Abstract class         | A class with or without abstract methods |
// | Abstract method        | A method with no body                    |
// | Cannot be instantiated | You can’t do `new AbstractClass()`       |
// | Must be subclassed     | Must define a concrete subclass          |



abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car started");
    }
}


public class lec8_abstract_class {

    public static void main(String[] args) {
        Car alto = new Car() ; 
        alto.start() ; 
    }

    
}
