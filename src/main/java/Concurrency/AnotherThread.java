package Concurrency;

import static Concurrency.ThreadColor.ANSI_BLUE; // Thread One Color


/* Tell thread what code to run */
// By creating a subclass of the thread and overriding the run method
// Sub-class of Thread Class
public class AnotherThread extends Thread {

    @Override
    public void run() {

        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());

        try {
            Thread.sleep(5000); // run thread every 3 seconds
        } catch(InterruptedException e) { // Another thread interrupt exception
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            return; // return => Termination up Interruption
        }

        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake");
    }
}
