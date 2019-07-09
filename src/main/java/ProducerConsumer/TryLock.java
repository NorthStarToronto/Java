package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static ProducerConsumer.Main.EOF;

/*
   Critical Sections of code enclosed in try finally block 2X
   1) Need to Only call unlock in one place
   2) Throw an exception that are not explicitly handling
 */
public class TryLock {

    public static final String EOF = "EOF";

    public static void main(String[] args) {

        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock(); // Order matters: Top => Down
        MyProducerNew2 producer = new MyProducerNew2(buffer, ThreadColor.ANSI_RED, bufferLock);
        MyConsumerNew2 consumer1 = new MyConsumerNew2(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        MyConsumerNew2 consumer2 = new MyConsumerNew2(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

/* 2X Threads for reading & writing to buffer */
class MyProducerNew2 implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    /* 2X Inputs: Shared Buffer and Color */
    public MyProducerNew2(List<String> buffer, String color, ReentrantLock bufferLock) {
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
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000)); // throws exception
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting ...");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}


class MyConsumerNew2 implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumerNew2(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    /* Thread test whether a lock is available
       => Available: acquire the lock and execute the critical code
       => Unavailable: alternatively execute different code
     */
    @Override
    public void run() {
        int counter = 0;
        while(true) {
            if(bufferLock.tryLock()){
                try {
                    if(buffer.isEmpty()) {
                        continue;
                    }
                    /* Print how many false loops had to be executed before the lock */
                    System.out.println(color + "The counter = " + counter);
                    counter = 0;

                    if(buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed" + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
        }
    }

    /*
        Re-entrant lock constructor: Accepts a fairness parameter
                                     FIFO Implemented
                                     Giving the priority over the thread who have been waiting the longest

        Check for the number of threads waiting for the lock by calling get queued length method
     */
}
