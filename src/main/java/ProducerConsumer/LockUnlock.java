package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static ProducerConsumer.Main.EOF;

/* Synchronized Blocks: Drawbacks => Use Lock Interface
   LockUnlock.java
   => Another way of preventing thread interference
   Use lock method to acquire the lock
   Use unlock method to release the lock
   => No automatic release
   => Manual release required
   vs Using Synchronized blocks
   => Automatic release when thread holding the lock exits the synchronized block
   A thread calls the lock method => Either obtain the lock & continue executing
   or unable to obtain as pre-existing thread is using it => Suspended
 */
public class LockUnlock {

    public static final String EOF = "EOF";

    public static void main(String[] args) {

        List<String> buffer = new ArrayList<String>();

        /* Create the lock instances & share it with the producer and consumer
           Caveat: The all thread have to be competing for the same lock
         */
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducerNew producer = new MyProducerNew(buffer, ThreadColor.ANSI_RED, bufferLock);
        MyConsumerNew consumer1 = new MyConsumerNew(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        MyConsumerNew consumer2 = new MyConsumerNew(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

/* 2X Threads for reading & writing to buffer */
// Change the classes accordingly
class MyProducerNew implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    /* 2X Inputs: Shared Buffer and Color */
    public MyProducerNew(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1","2","3","4","5"};

        for(String num: nums) {
            try {
                System.out.println(color + "Adding ... " + num);
//                synchronized (buffer) {
                bufferLock.lock();
                buffer.add(num);
                bufferLock.unlock();
//                }
                Thread.sleep(random.nextInt(1000)); // throws exception
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting ...");
//        synchronized (buffer) {
            bufferLock.lock();
            buffer.add("EOF");
            bufferLock.unlock();
//        }

    }
}


class MyConsumerNew implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumerNew(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }


    /*
       Enter the Loop => Check if Buffer has any data => If data continue to through the loop code
       => Otherwise, Get the the Lock
     */

    @Override
    public void run() {
        while(true) {

//            synchronized (buffer) {
            bufferLock.lock();
            if(buffer.isEmpty()) {
                bufferLock.unlock();
                continue;
            }

            if(buffer.get(0).equals(EOF)) {
                System.out.println(color + "Exiting");
                bufferLock.unlock();
                break;
            } else {
                System.out.println(color + "Removed" + buffer.remove(0));
            }
            bufferLock.unlock();
//            }
        }
    }

    /* Always enclose the critical sections of code with a try finally block */
}
