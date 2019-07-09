package Core1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Main {

    public static void main(String[] args) {

        /* Data Types */
        byte  byteValue = 18;
        short shortValue = 20;
        int intValue = 50;

        long longTotal = 50000L + 10L * (byteValue + shortValue);
        short shortTotal = (short) (1000 + 10 *(byteValue + shortValue + intValue));
        System.out.println("longTotal = " + longTotal);
        System.out.println("shortTotal = " + shortTotal);

        // width of int = 32 (4 bytes)
        int myIntValue = 5 / 3;

        // width of float = 32 (4 btyes)
        float myFloatValue = 5f / 3f;
        double myDoubleValue = 5d / 3d;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue = " + myFloatValue);
        System.out.println("myDoubleValue = " + myDoubleValue);

        double numPounds = 200d;
        double convertedKilogram = numPounds * 0.4539284d;
        System.out.println("Kilogram = " + convertedKilogram);

        // width of 16 (2 bytes)
        char myChar = '\u00C6';
        System.out.println("Unicode printed is : " + myChar);

        String lastString = "This is a string";
        System.out.println(lastString + " Wowo");

        /* Operators: Special symbols that perform */
        int result = 1 + 2;
        System.out.println("1 + 2 = " + result);

        System.out.println("Print result ... " + result);
        result++;
        System.out.println("Print result ... " + result);
        result--;
        System.out.println("Print result ... " + result);
        result+=1;
        System.out.println("Print result ... " + result);
    }
}
