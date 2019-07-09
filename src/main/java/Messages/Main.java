package Messages;

import java.util.Random;
/* Thread Safe: Race Conditions or Thread Interference
 Synchronization: Threads can be suspended while executing a single line of code (a method call with 100 lines, hundred operations)
 before & after each operations
 Some collection classes are not thread safe => asynchronous
 E.g. array list & multiple thread access

 Deadlock: Waiting for other thread to release
 Wait, Notify, Notify all
 */


// Use Static Method and Object for Synchronisation: Lock owned by Class
// Critical Section: Code referencing a shared resource like a variable/ only one thread at a time execute
// Thread-safe: Class/Method "Synchronized"
// Recommended => only necessary "Block method"
// Methods only called in Synchronized code: Notify Notify all

// 2X Threads: Produce and Consume
public class Main {

    public static void main(String[] args) {

        // Create 2X Threads
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

/* Deadlock: Thread is locking the message object and the other thread waiting for the release */
class Message {
    private String message;
    private boolean empty=true; // if not assign empty null => run() X

    // Don't want another thread to read or write while one thread is reading or writing
    public synchronized String read() {
        while(empty) {
            try {
                wait(); // Always within the loop
            } catch (InterruptedException e) {

            }
        }
        empty = true;
        notifyAll();
        return this.message;
    }

    public synchronized void write(String message) {
        while(!empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }

        }
        empty = false;
        this.message= message;
        notifyAll();
    }
}

// Producer
class Writer implements Runnable {

    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {
                "Humpty dumpty sat on a wall",
                "Humpty dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };

        Random random = new Random();

        for(int i=0;i<messages.length; i++) {
            this.message.write(messages[i]);
            try {
                Thread.sleep( random.nextInt(2000));
            } catch(InterruptedException e){

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {

    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(String latestMessage = message.read(); !latestMessage.equals("Finished");
            latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000)); // sleep upto 2 seconds
            } catch (InterruptedException e) {

            }
        }
    }
}