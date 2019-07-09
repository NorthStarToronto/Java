package Concurrency;

/* Bank Accounts/ Employee Records => Each thread use the same object to maintain the integrity => Update and Write the same object */
// Several threads: Schedule Payment, Automatic Deposit
// Allow multiple threads to change but
// Prevent Race Condition

/*
 Synchronisation: The process of controlling when threads execute code and access heap
 Ways
 1) Synchronize Method: Only one thread can execute at a time => Whole method to run before another threads gets access to
 2) Synchronize Block Statement: Locked for one thread
 3) Intrinsic lock on object only; primitive type X
 4) Synchronize Shared Object: local variable X (call stack memory, separate object)
 Local object variable: Reference stored in the thread stack vs Value stored in heap
 */

public class Synchronisation {
    public static void main(String[] args) {

        /*2X threads counting down from ten using a count down object => 2X Class: Countdown & Countdown thread */
        CountdownNew countdown = new CountdownNew();

        /* Passing down the same countdown object */
        CountdownThreadNew t1 = new CountdownThreadNew(countdown);
        t1.setName("Thread 1");
        CountdownThreadNew t2 = new CountdownThreadNew(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class CountdownNew {

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

//        public void doCountdown() {
//        Synchronized(this) {
//        "local object variable"
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

class CountdownThreadNew extends Thread {
    private CountdownNew threadCountdown;

    // constructor
    public CountdownThreadNew(CountdownNew countdown) {
        threadCountdown = countdown;
    }

    // Create a run method
    public void run() {
        // execute the method
        threadCountdown.doCountdown();
    }
}

