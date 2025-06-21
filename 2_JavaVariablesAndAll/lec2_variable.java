// Java Variables
// Variables in Java are containers that hold data values.
// They are used to store information that can be referenced and manipulated in a program.
// Types of Variables in Java:
// 1. Local Variables
// 2. Instance Variables
// 3. Static Variables

// Local Variables are declared inside a method, constructor, or block.
// They are created when the method, constructor, or block is entered and destroyed when it exits.


// Instance Variables are declared in a class but outside any method, constructor, or block.
// They are created when an object of the class is created and destroyed when the object is destroyed.


// Static Variables are declared with the static keyword in a class but outside any method, constructor, or block.
// Local variables must be initialized before use, while instance and static variables are initialized to default values (0, null, etc.).



class Student {
    public String name;  // instance variable
    public int age;      // instance variable

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

   
}



public class lec2_variable {

    public void show() {
        int x = 10;     // local variable
        System.out.println(x);
    }

    public class College{
        static String school = "ABC School";  // static variable. ; 
    }






     public static void main(String[] args) {
        Student student = new Student();
        student.name = "John";
        student.age = 20;
        student.display();

        lec2_variable variableExample = new lec2_variable();
        variableExample.show();

        
        System.out.println(College.school) ;

    }




}
