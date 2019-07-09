package Core4;

import java.util.Scanner;

public class ArrayChallenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter count: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        int[] returnedArray = readIntegers(count);
        int returnedMin = findMin(returnedArray);
        System.out.println("Minimum value : " + returnedMin);
    }

    public static int[] readIntegers(int count) {

        int[] array = new int[count];
        for(int i=0; i<array.length; i++) {
//            array[i] = scanner.nextInt();
            System.out.println("Enter a number : ");
            int number = scanner.nextInt();
            scanner.nextLine();
            array[i] = number;
        }
        return array;
    }

    public static int findMin(int[] intArray) {

        int min = Integer.MAX_VALUE;

        for(int i=0; i< intArray.length;i++) {
            int value = intArray[i];
            if(value < min) {
                min = value;
            }
        }

        return min;
    }
}



