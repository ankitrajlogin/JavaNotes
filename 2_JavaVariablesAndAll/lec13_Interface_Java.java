

// What is an Interface in Java?
// An interface in Java is like a contract that defines what methods a class should have, but not how they work.

// In simple words:

// An interface has only method declarations, not method bodies (logic).

// Any class that implements an interface must define the behavior (i.e., give body to those methods).


interface Animal {
    void speak();  // method without body
}


class Dog implements Animal {
    public void speak() {
        System.out.println("Barks");
    }
}

class Cat implements Animal {
    public void speak() {
        System.out.println("Meows");
    }
}



// example with runnable interface 

interface Runnable_custom {
    void run();  // no body → just a method declaration
}

class MyTask implements Runnable_custom {
    public void run() {
        System.out.println("Running a task...");
    }
}




public class lec13_Interface_Java {
    public static void main(String arg[]){

        Runnable_custom task = new MyTask();
        task.run();  // runs on main thread (no threading)

    }
}

// | Mistake                             | Fix                                      |
// | ----------------------------------- | ---------------------------------------- |
// | Created your own `Runnable_custom`  | ❌ Not compatible with `Thread`           |
// | Passed `MyTask` to `Thread`         | ✅ Only works if it implements `Runnable` |
// | Tried to match constructor manually | ✅ Use Java's built-in interface          |
