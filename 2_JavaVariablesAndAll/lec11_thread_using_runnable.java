
// What is Runnable in Java?
// 🔹 Runnable is a functional interface in Java that represents a task that can be executed by a thread.




class MyRunnableTask implements Runnable {
    @Override
    public void run() {
        // Step 2: Define what this thread will do
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(500); // simulate some work
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        }
    }
}

public class lec11_thread_using_runnable {
    public static void main(String[] args) {
        // Step 4: Create Runnable objects
        MyRunnableTask task1 = new MyRunnableTask();
        MyRunnableTask task2 = new MyRunnableTask();

        // Step 5: Create Thread objects and assign Runnable tasks
        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        // Step 6: Start both threads
        thread1.start();
        thread2.start();

        // thread1.join();
        // thread2.join() ;  --> it through error as join have to wrap join() ; 


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }





        // runnable with lambda expression
        
        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " running " + i);
            }
        };

        Thread t3 = new Thread(task, "Lambda-Thread-1");
        Thread t4 = new Thread(task, "Lambda-Thread-2");

        t3.start();
        t4.start();


    }
}
