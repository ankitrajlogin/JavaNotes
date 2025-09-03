
// What is a Class in Java?
// A class is a blueprint or template from which objects are created.
// It defines properties (fields) and behaviors (methods) that the objects will have.

// [access_modifier] class ClassName {
//     // 1. Fields / Variables
//     // 2. Constructors
//     // 3. Methods
//     // 4. Blocks (static/instance)
//     // 5. Inner Classes (optional)
// }


//  1. Access Modifiers
// These control where the class or its members can be accessed from:
// | Modifier    | Scope                        |
// | ----------- | ---------------------------- |
// | `public`    | Anywhere                     |
// | `private`   | Only within the same class   |
// | `protected` | Same package or subclass     |
// | (default)   | Only within the same package |


public class lec2_class {

    private String name;
    private int age;

    // 🔸 3. Constructor
    public lec2_class(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("constructor has been called");
    }

    // 🔸 4. Method
    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }

    // 🔸 5. Getter Method
    public int getAge() {
        return age;
    }

    // 🔸 6. Setter Method
    public void setAge(int age) {
        this.age = age;
    }

    // 🔸 7. Static block (runs once when class is loaded)
    static {
        System.out.println("Class Person is loaded");
    }

    // 🔸 8. Instance block (runs before constructor)
    {
        System.out.println("New Person object is being created");
    }

    // 🔸 9. toString() override (optional)
    @Override
    public String toString() {
        return name + " (" + age + " years)";
    }

    // 🔸 10. Main method (entry point for execution)
    public static void main(String[] args) {
        lec2_class p = new lec2_class("Ankit", 23);
        p.sayHello();
        System.out.println(p);
    }
}
