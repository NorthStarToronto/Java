package OOP3;

/* Inner Class: Nested Class 4X Types */
// Access the nonstatic methods or members after creating an instance
// Two Special Cases:
// Local Class : Rarely Used but
// Anonymous Class

public class InnerClasses {

    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(6);

//        /* Gear Public*/
//        Gearbox.Gear first = mcLaren.new Gear(1, 12.3); // Use Nested Gear Class and Use mcLarne Instance
//        System.out.println(first.driveSpeed(1000));

        /* Gear Private Class: Accessed only through GearBox Methods */
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));

    }
}
