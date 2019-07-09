package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static ProducerConsumer.Main.EOF;

/*
    Implement executive service interface to automatically manage threads optimization for creating and starting them
    => Still need to provide runnable objects
    => Different type of thread polls
    => Need to shut down each services even if main thread is done
 */
public class ThreadPools {

    public static final String EOF = "EOF";

    public static void main(String[] args) {

        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock(); // Order matters: Top => Down

        /* 1X Producer Thread, 2X Consumer Thread */
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducerNew3 producer = new MyProducerNew3(buffer, ThreadColor.ANSI_RED, bufferLock);
        MyConsumerNew3 consumer1 = new MyConsumerNew3(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        MyConsumerNew3 consumer2 = new MyConsumerNew3(buffer, ThreadColor.ANSI_CYAN, bufferLock);

//        new Thread(producer).start();
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        /* Receive a value back from a thread that are being executed => Use submit method with callable object
           and receive future object
         */
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_GREEN + "I'm being printed for the Callable class");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch(ExecutionException e) {
            System.out.println("Something went wrong");
        } catch(InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();
    }
}

/* 2X Threads for reading & writing to buffer */
class MyProducerNew3 implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    /* 2X Inputs: Shared Buffer and Color */
    public MyProducerNew3(List<String> buffer, String color, ReentrantLock bufferLock) {
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


class MyConsumerNew3 implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumerNew3(List<String> buffer, String color, ReentrantLock bufferLock) {
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
}
