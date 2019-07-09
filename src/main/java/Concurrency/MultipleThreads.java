package Concurrency;

/* Heap/ Application Memory: All Threads Share
  , Process unique memory, instance variable, share  */
/* Thread Stack: Memory only that Thread can access
   Thread unique memory, local variable */

// Local Variable is stored in Thread Stack => Each thread has its own copy of local variable
// An object instance value => stored in Heap

// Create an object subclass from thread and call the start method
// Or Create an instance of the thread class with a runnable object
/* Synchronisation: The process of controlling when threads execute code and access heap memory */
// 1) Method Synchronisation: One thread execution at a time/ All other method in the class suspended until the thread exit the heap
// 2) Statement Synchronisation


/* Minimize Synchronisation to Minimum */
// Change local variable to instance variable
// Thread 1 executes and changes the value of i & then get suspended => Thread 2 execute and see new value i that has been updated by Thread 1
public class MultipleThreads {
    public static void main(String[] args) {

        /*2X threads counting down from ten using a count down object => 2X Class: Countdown & Countdown thread */
        Countdown countdown = new Countdown();

        /* Passing down the same countdown object */
        CountdownThread t1 = new CountdownThread((countdown));
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class Countdown {

    private int i; // instance variable

    // create a method
    public synchronized void doCountdown() {
        String color;

        /* Set the Color */
        switch(Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        /* Race Condition */
        // local variable int i=0
        /* Multiple suspension points */
        // For loop consists of several steps and thread can be suspended between each step 3X separated by ";"
        // suspended after the for has decremented the I variable but before the condition has been checked
        //again another example it could also be suspended after executing all the code
        //associated with the for loop but before executing the print line

        /* Thread Interference: Threads are interleaving and accessing the same resources */
        // Race Condition: When two or more threads are writing a share resource
        // No problem reading <=> At least one thread is updating or writing resourceMultipleThreads.java
        for(i=10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
        }
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    // constructor
    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    // Create a run method
    public void run() {
        // execute the method
        threadCountdown.doCountdown();
    }
}

