
// What is StringBuffer?
// StringBuffer is a mutable sequence of characters like StringBuilder.
// Unlike String, it allows you to modify strings without creating new objects.
// The key difference: StringBuffer is thread-safe.


// Why is StringBuffer Thread-Safe?
// Because it uses synchronized methods.
// Every method in StringBuffer (like append, insert, delete) is marked synchronized.
// This means:
// 1. Only one thread at a time can access a method on the same StringBuffer object.
// 2. Other threads trying to access it must wait until the lock is released.


public class lec9_String_Buffer {
    public static void main(String[] args) {
        StringBuffer sharedBuffer = new StringBuffer("Start");


        // Runnable task = () -> { ... };
        // is a shortcut for writing a class that implements Runnable, overrides the run() method, and stores the object in task.
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                sharedBuffer.append(" " + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + " "+  sharedBuffer);
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final content: " + sharedBuffer.toString());
    }
}


// Summary
// | Part                     | Role                                                                |
// | ------------------------ | ------------------------------------------------------------------- |
// | `StringBuffer`           | Thread-safe mutable string buffer                                   |
// | `Runnable`               | Shared task logic for both threads                                  |
// | `Thread.currentThread()` | Gets the name of the running thread                                 |
// | `t1.start(), t2.start()` | Starts both threads                                                 |
// | `join()`                 | Ensures main waits for both threads to finish                       |
// | Final Output             | Shows combined string safely built by both threads (order may vary) |






// NOTE : 

// This lambda:
// Runnable task = () -> {
//     // some logic
// };

// is the same as writing:

// Runnable task = new Runnable() {
//     public void run() {
//         // some logic
//     }
// };