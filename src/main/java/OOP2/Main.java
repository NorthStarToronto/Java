package OOP2;

/* General Rule: Use Composition First over Inheritance "More Flexibility */
public class    Main {
    public static void main(String[] args) {

        /* Composition - has/ parts of a whole/ not the whole */
        Dimensions dimensions = new Dimensions(20,20, 5);
        Case theCase = new Case("2200", "Dell", "240", dimensions);

        Monitor theMonitor = new Monitor("27 inch beast", "Acer", 27, new Resolution(2540, 1440));

        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        /* Create a PC by passing three other objects */
        PC thePC = new PC(theCase, theMonitor, theMotherboard);
        thePC.powerUp();

        /* Inheritance: Use method name this vs super
           Composition: Use Getter to fetch composite object and use instance method on it
           PC has a monitor, a motherboard, and a case
           A monitor, a motherboard, and a case is not a PC

         */
//        thePC.getMontior().drawPixel(1500,1200,"red");
//        thePC.getMotherboard().loadProgram("Windows 1.0");
//        thePC.getTheCase().pressPowerButton();


        /* When to use Composition vs Inheritance => Choose Composition first */

    }

}

