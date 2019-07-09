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
public class TryFinally {

    public static final String EOF = "EOF";

    public static void main(String[] args) {

        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock(); // Order matters: Top => Down
        MyProducerNew1 producer = new MyProducerNew1(buffer, ThreadColor.ANSI_RED, bufferLock);
        MyConsumerNew1 consumer1 = new MyConsumerNew1(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        MyConsumerNew1 consumer2 = new MyConsumerNew1(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

/* 2X Threads for reading & writing to buffer */
class MyProducerNew1 implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    /* 2X Inputs: Shared Buffer and Color */
    public MyProducerNew1(List<String> buffer, String color, ReentrantLock bufferLock) {
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


class MyConsumerNew1 implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumerNew1(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    /* Illegal monitor state exception: Calling unlock when we don't own the lock */
    @Override
    public void run() {
        while(true) {
            bufferLock.lock();
            try {
                if(buffer.isEmpty()) {
                    continue;
                }
                if(buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    System.out.println(color + "Removed" + buffer.remove(0));
                }
            } finally {
                bufferLock.unlock();
            }
        }
    }
}
