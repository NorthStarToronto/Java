package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/* Exception vs Runtime exception */

public class Main {

    public static void main(String[] args) {
        int x = 98;
        int y = 0;
        System.out.println(divideLBYL(x, y));
        System.out.println(divideEAFP(x, y));
//        System.out.println(divide(x, y)); => Exception in thread "main" java.lang.ArithmeticException: / by zero

        x = getIntEAFP(); // same method int x = X
        System.out.println("Entered integer is " + x);
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    // Check for a key existence or map.get method
    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer ");
        String input  = s.next();
        for(int i=0; i<input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
        if(isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        try {
            return s.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    /* Regular Divide */
    private static int divide(int x, int y) {
        return x / y;
    }

    /* Look Before You Leap Approach */
    private static int divideLBYL(int x, int y) {
        if(y!=0){
            return x/y;
        } else {
            return 0;
        }
    }

    /* Easy to Ask for Forgiveness than Permission */
    private static int divideEAFP(int x, int y) {
        try {
            return x/y;
        } catch(ArithmeticException e) {
            return 0;
        }
    }
}
