package Exception;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* Stack Trace : Showing Call Stack - list of all method calls */
// Prints Stack Trace
// First Line: => Thread
/*
   Each thread of execution has its own call stack
   Thread is shown as the first line of the stack trace
   Ctrl + D
   Every time a new method is called => placed onto the stack
   Exception will be thrown from the method
   Exception extends throwable(fills in the stack trace)
   Work back up the call stack for handling the exception until main java entry
   prints the stack trace and terminates
 */
public class Exception {

    /* Real-world app: Catch the exceptions in the main method "Bitwise Inclusive */
    public static void main(String[] args) {

        try{
            int result = divide();
            System.out.println(result);
        } catch(ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to peform division, autopilot shutting down");
        }
    }

    /* Multi Catch */
    // Ensure exceptions are not raised in New Exception handler code
    private static int divide() {
        int x, y; // {} block scope declare

        /* Main Line */
//        try {
        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
    }
        /* Different Exceptions */
//        } catch (NoSuchElementException e) {
//            throw new ArithmeticException("No suitable input");
//        } catch (ArithmeticException e) {
//            throw new ArithmeticException("Attempt to divide by zero");
//        }
//    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        while(true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                // go round again, Read past the end of time in the input first
                s.nextInt();
                System.out.println("Please enter a number using only the digits 0 to 9");
            }
        }
    }
}
