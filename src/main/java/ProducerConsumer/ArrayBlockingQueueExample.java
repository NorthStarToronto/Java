package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static ProducerConsumer.Main.EOF;

/* Thread safe queues:
   => Processes elements FIFO "Consumer removes always the first element of arrays"
   => Pass in number of elements arrays hold to its capacity before a consumer has a chance to remove them
 */
public class ArrayBlockingQueueExample {

    public static final String EOF = "EOF";

    public static void main(String[] args) {

        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        /* 1X Producer Thread, 2X Consumer Thread */
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducerNew4 producer = new MyProducerNew4(buffer, ThreadColor.ANSI_RED);
        MyConsumerNew4 consumer1 = new MyConsumerNew4(buffer, ThreadColor.ANSI_BLUE);
        MyConsumerNew4 consumer2 = new MyConsumerNew4(buffer, ThreadColor.ANSI_CYAN);

//        new Thread(producer).start();
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

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

/* Producers to block when queue is locked by another thread */
class MyProducerNew4 implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    /* 2X Inputs: Shared Buffer and Color */
    public MyProducerNew4(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1","2","3","4","5"};

        for(String num: nums) {
            try {
                /* Put method to add elements */
                System.out.println(color + "Adding ... " + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(1000)); // throws exception
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting ...");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e){

        }
    }
}


class MyConsumerNew4 implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumerNew4(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    /* Thread test whether a lock is available
       => Available: acquire the lock and execute the critical code
       => Unavailable: alternatively execute different code
     */
    @Override
    public void run() {

        while(true) {

            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }

                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        /* Call Take and block until something's in the queue */
                        System.out.println(color + "Removed " + buffer.take());
                    }

                } catch (InterruptedException e) {

                }
            }
        }
    }

    /*
       thread safe means that we can be confident that our call to one of
       the class methods will complete before another thread can run a method in the
       class so the producer code only calls the put method and the code
       following the put doesn't depend on the result of the put however in the
       consumer code what we're doing is we check to see if the queue is empty
       if it isn't we then peak at the next element but the consumer thread can be
       suspended between calling is empty and calling peak while it suspended the
       other consumer thread can run and take the next element from the queue when the
       suspended consumer thread runs again peak returns null and consequently we
       get a null pointer exception when we call the equals method and that's what
       happened in this scenario because you can see that the errors on line 93
       which is the peak method so what that all means is that we may still have to add
       synchronization code when using thread-safe classes like array blocking queue
     */
}
