


// What is @Override in Java?
// The @Override annotation tells the compiler that a method is intended to override a method in a superclass or interface.

// 🎯 Why use @Override?
// Compile-time error checking (avoids mistakes)
// Improves code readability
// Enforces correct overriding
// Used in polymorphism (dynamic/compile-time)
// Used in interface implementation



// What happens if we don’t use @Override while overriding a method in Java?
// ✅ Short Answer:
// The code will still work if the method is correctly overriding a method from the parent class.

// But if you make a mistake (like a typo or wrong parameters), the compiler will not warn you, and your method will not override—it will just be treated as a new method.


class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name; 
        this.age = age;
    }

    // 🔸 toString() - For human-readable object print
    @Override
    public String toString() {
        return name + " is " + age + " years old";
    }

    // 🔸 equals() - For value-based object comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person p = (Person) obj;
        return this.age == p.age && this.name.equals(p.name);
    }

    // 🔸 hashCode() - Must override if equals() is overridden
    @Override
    public int hashCode() {
        return name.hashCode() + Integer.hashCode(age);
    }
}


public class lec4_override {
    public static void main(String[] args) {
        Person p1 = new Person("Ankit", 23);
        Person p2 = new Person("Ankit", 23);
        Person p3 = new Person("Raj", 25);

        // 📌 Demonstrating toString()
        System.out.println("p1: " + p1); // → Ankit is 23 years old

        // 📌 Demonstrating equals()
        System.out.println("p1 equals p2? " + p1.equals(p2)); // → true
        System.out.println("p1 equals p3? " + p1.equals(p3)); // → false

        // 📌 Demonstrating hashCode()
        System.out.println("p1 hashCode: " + p1.hashCode());
        System.out.println("p2 hashCode: " + p2.hashCode());
        System.out.println("p3 hashCode: " + p3.hashCode());

        // 📌 Demonstrating behavior in HashSet
        java.util.HashSet<Person> set = new java.util.HashSet<>();
        set.add(p1);
        set.add(p2); // Won't be added if equals & hashCode are correctly overridden
        set.add(p3);
        System.out.println("Set size: " + set.size()); // → 2
    }
}
