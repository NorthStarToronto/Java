package Concurrency;

import static Concurrency.ThreadColor.ANSI_RED;
/* Use the runnable interface and implement a single method run in any class */
// Write the code in the run method to execute on a thread that is being created
// Recommended method for creating a thread

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello form MyRunnable's implementation of run()");
    }
}
