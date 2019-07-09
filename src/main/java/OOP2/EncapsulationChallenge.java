package OOP2;

import OOP2.Printer;

import java.io.PrintWriter;

public class EncapsulationChallenge {

    public static void main(String[] args) {
        Printer printer = new Printer(50,true);
        System.out.println("Initial page count = " + printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("Pages printed was " + printer.getPagesPrinted() + " new total print count for printer " + printer.getPagesPrinted());
        pagesPrinted = printer.printPages(2);
        System.out.println("Pages printed was " + printer.getPagesPrinted() + " new total print count for printer " + printer.getPagesPrinted());
    }
}
