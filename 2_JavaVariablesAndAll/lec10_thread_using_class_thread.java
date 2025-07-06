
// another ways to create runner. 

class MyThread extends Thread {
    private String threadName;

    // Constructor to assign custom name
    MyThread(String name) {
        this.threadName = name;
    }

    // Override the run() method
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - Count: " + i);
            try {
                Thread.sleep(500); // Pause to simulate work
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
    }
}

public class lec10_thread_using_class_thread{
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        // Start both threads
        t1.start();
        t2.start();
    }
}



// Commonly Used Methods of Thread
// | Method             | Description                                    |
// | ------------------ | ---------------------------------------------- |
// | `start()`          | Starts the thread and calls `run()` internally |
// | `run()`            | Code that gets executed in the thread          |
// | `join()`           | Waits for the thread to finish execution       |
// | `sleep(ms)`        | Pauses the thread for a given time (in ms)     |
// | `getName()`        | Gets the thread’s name                         |
// | `setName("name")`  | Sets the thread’s name                         |
// | `isAlive()`        | Checks if the thread is still running          |
// | `setPriority(int)` | Sets thread priority (1 to 10)                 |
