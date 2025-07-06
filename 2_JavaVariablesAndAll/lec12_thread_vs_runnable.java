
// In Simple Words:
// Thread is the worker.
// Runnable is the job/task that the worker does.
// Think of a thread as a delivery boy (Thread), and the delivery item or route as the job (Runnable).


// Analogy 
// | Concept    | Real World Analogy         |
// | ---------- | -------------------------- |
// | `Runnable` | A **job description**      |
// | `Thread`   | A **person doing the job** |



// Runnable is not a class, it's an interface.
// Thread is a class that implements the Runnable interface internally.




class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

class MyTask implements Runnable {
    public void run() {
        System.out.println("Runnable is running...");
    }
}


public class lec12_thread_vs_runnable {


    // thread 
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();


        MyTask task = new MyTask();
        Thread t2 = new Thread(task);
        t2.start();
    }
    
}


// Key Difference between thread and runnable 

// | Feature                        | `Thread` Class                                        | `Runnable` Interface                              |
// | ------------------------------ | ----------------------------------------------------- | ------------------------------------------------- |
// | Type                           | Class                                                 | Functional Interface (with one method: `run()`)   |
// | Inheritance                    | Must extend `Thread` (you can't extend another class) | Can implement Runnable and extend other classes ✅ |
// | Flexibility                    | Less flexible                                         | More flexible and reusable ✅                      |
// | Recommended                    | ❌ Not recommended for real apps                       | ✅ Best practice                                   |
// | Separation of task and thread  | No — thread logic is tightly coupled                  | Yes — you separate logic and thread ✅             |
// | Lambda Support (Java 8+)       | ❌ No                                                  | ✅ Yes                                             |
// | Used in Executors/Thread Pools | ❌ No                                                  | ✅ Yes                                             |





// NOTE : 
// Runnable is not a class, it's an interface.
// Thread is a class that implements the Runnable interface internally.


// ----------------------------------------------------
// public interface Runnable {
//     public abstract void run();
// }

// public class Thread implements Runnable {
//     public void run() {
//         if (target != null) {
//             target.run(); // where target is a Runnable task
//         }
//     }
// }
// ---------------------------------------------------------





