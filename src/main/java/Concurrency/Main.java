package Concurrency;

import java.beans.IntrospectionException;

import static Concurrency.ThreadColor.ANSI_GREEN; // Anonymous Thread Color
import static Concurrency.ThreadColor.ANSI_PURPLE; // Main Thread Color
import static Concurrency.ThreadColor.ANSI_RED;

/* Process & Multi-Threading */
// Up to the system to schedule each thread priority and run order
// Using a subclass of thread => Cannot use the same instance


public class Main {

    /* Create Main Thread */
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");

        /* Create an instance of the anotherThread */
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread =="); // set the name of the thread

        /* Start the created anotherThread */
        anotherThread.start(); // JVM call the run method for the application => code in the run method will implemented on a new thread
        // anotherThread.run(); => run executed on the same thread

        /* Create Anonymous Class => Must Start Immediately */

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();


        /* Create an instance of the thread class
           Not a subclass
           Pass an instance of MyRunnable class to the thread constructor
         */

        /* Use an instance of Runnable Interface implemented MyRunnable Class */
        // Thread myRunnableThread = new Thread(new MyRunnable());

        /* Create anonymous class of myRunnable and override the run method */

        // Recommend Using Runnable Method; Many methods in JAVA API have a runnable instance passed in "Flexible"
        // Anonymous class implement runnable
        // Interrupt the thread to terminate the current task e.g. Task Performing Thread, Thread Monitoring Thread

//        Thread myRunnableThread = new Thread(new MyRunnable(){
//            @Override
//            public void run() {
//                System.out.println(ANSI_RED + "Hello from anonymous class implementation");
//            }
//        });

        /* Join myRunnable anonymous thread to anotherThread
           anonymous will stop until anotherThread terminates then wake up
         */
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
                try {
                    /* Join the Current Thread to anotherThread */
                    anotherThread.join(2000); // Add a time out value => Earliest between Terminate and Timeout period
                    System.out.println(ANSI_RED + "AnotherThread terminated, or timed out so I'm running again");
                } catch(InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted"); // join prematurely interrupted
                }
            }
        });

        myRunnableThread.start();
//        anotherThread.interrupt(); => Main thread Interrupts/terminates anotherThread

        System.out.println(ANSI_PURPLE + "Hello again from the main thread");

        /* What to do with an running thread */
        // Sleep => Stop executing & give other threads opportunity to run
        // do something every specific time
    }
}
