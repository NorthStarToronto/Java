package Core4;

import java.util.ArrayList;

public class AutoboxingUnboxing {

    public static void main(String[] args) {

        /* Array Examples */
        String[] strArray = new String[10];
        int[] Array = new int[10];

        /* ArrayList Example */
        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Tim");

        // ArrayList<int> intArrayList = new ArrayList<int>(); X
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));

        /* ArrayList and Other Classes needs to have a class passed
           => To pass primitive type: create a class and parse it
           => Automatic Object Wrapper on primitive type "Autoboxing"
         */

        Integer integer = new Integer(54);
        Double doubleValue = new Double(12.25);

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();

        /* Autoboxing: A base primitive type int => Integer */
        for(int i=0; i<=10; i++) {
            intArrayList.add(Integer.valueOf(i));
        }

        Integer myIntValue = 56; // Integer.valueOf(56);

        /* Unboxing: Integer Class => base primitive int */
        for(int i=0;i<=10;i++) {
            System.out.println(i + " -> " + intArrayList.get(i).intValue());
        }

        int myInt = myIntValue; //myIntValue.intValue();

        ArrayList<Double> doubleArrayList = new ArrayList<Double>();


        for(double dbl=0; dbl<=10; dbl+=0.5) {
            doubleArrayList.add(dbl);
//            doubleArrayList.add(Double.valueOf(dbl));
        }

        for(int i=0; i<doubleArrayList.size();i++) {
            double value = doubleArrayList.get(i).doubleValue();
            System.out.println(i+ " -> " + value);
        }

    }
}


class IntClass {
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}
