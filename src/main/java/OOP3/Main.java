package OOP3;

/* Intreface */
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    /* Inner & Abstract Classes and Interfaces */

    // Interface : Standardize the way a particular classes is used
    public static void main(String[] args) {

        /* Inner Clases: Nested Class */
        // Cannot access non-static methods or member before creating an instance of outer class
        // Gear is local to Gearbox
        Gearbox mcLaren = new Gearbox(6);
        mcLaren.addGear(1, 5.3);
        mcLaren.addGear(2, 10.6);
        mcLaren.addGear(3, 15.9);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3200));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6200));

        /* Abstract */
        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        // Abstract class have members that can be inherited
        // But public static final variables/. cannot change
        // abstract class cannot be directly initiated
        // static cuz non-static requires instance
        // Can have constructors
        // Methods can be public and private
        // Inteface public
        Parrot parrot = new Parrot("Red neck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Black");
        penguin.fly();
    }
}
