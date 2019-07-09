package Core4;

import java.util.Arrays;

public class ReverseArrayChallenge {
    public static void main(String[] args) {
        int[] array = {1,5,3,7,11,9,15};
        System.out.println("Array = " + Arrays.toString(array));

        reverse(array);

        System.out.println("Reversed array = " + Arrays.toString(array));

//        printArray(reverse(array));
    }

    private static void reverse(int[] array) {

        int maxIndex = array.length -1;
        int halfLength = array.length / 2;
        for(int i=0; i<halfLength;i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }

//    public static int[] reverse(int[] originalArray) {
//        int[] reverseArray = new int[originalArray.length];
//        for(int i=0;i<originalArray.length;i++) {
//            reverseArray[i]=originalArray[originalArray.length-i-1];
//        }
//        return reverseArray;
//    }
//
//    public static void printArray(int[] array) {
//        System.out.println("Array");
//        for(int i=0; i<array.length;i++) {
//            System.out.println(array[i]);
//        }
//    }
}
