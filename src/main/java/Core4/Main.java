package Core4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /* Array */
        int[] myIntArray = new int[25]; // {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}

        // create an array
        for (int i=0; i < myIntArray.length; i++) {
            myIntArray[i] = i*10;
        }

        // print the array
        printArray(myIntArray);

        // calculate the average
        int[] myIntegers2 = getIntegers(5);
        for(int i=0; i<myIntegers2.length; i++) {
            System.out.println("Element " + i + ", typed value was " + myIntegers2[i]);
        }
        System.out.println("The average is " + getAverage(myIntegers2));


        /* Reference Types vs Value Types */
        // Primitive Data type => Value Type
        int myIntValue = 10;
        int anotherIntValue = myIntValue;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);

        anotherIntValue++;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);


        // Array & String => Reference Type
        // Reference type holds reference/ address /memory to the object
        // same memory address, new object

        int[] myIntArray2 = new int[5];
        int[] anotherArray2 = myIntArray2;

        System.out.println("myIntArray2 = " + Arrays.toString(myIntArray2));
        System.out.println("anotherArray2 = " + Arrays.toString(anotherArray2));

        anotherArray2[0] = 1;

        System.out.println("after change myIntArrays = " + Arrays.toString(myIntArray2));
        System.out.println("after change myIntArrays = " + Arrays.toString(anotherArray2));

        // de-reference the array
        anotherArray2 = new int[]{4,5,6,7,8};
        modifyArray(myIntArray2);


        /* Autoboxing and Unboxing: Needed to store common primitive types */
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        // Array list must be object, primitive type X
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("Tim");

        // Auto-Boxing
        Integer integer = new Integer(54);
        Double doubleValue = new Double(12.25);


    }



    // class wrapper for primitive type
    class IntClass {
        private int myValue;

        public IntClass(int myValue) {
            this.myValue = myValue;
        }

        public void setMyValue(int myValue) {
            this.myValue = myValue;
        }

        public int getMyValue() {
            return myValue;
        }
    }

    private static void modifyArray(int[] array) {

        array[0] = 2;
        array = new int[] {1, 2, 3, 4, 5};
    }

    // create print method
    public static void printArray(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.println("Element " + i + "value is" + array[i]);
        }
    }

    // get integer
    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for(int i=0; i<values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    // create average method
    public static double getAverage(int[] array) {
        int sum = 0;
        for(int i=0; i<array.length; i++) {
            sum += array[i];
        }
        return (double) sum / (double) array.length;
    }
}
