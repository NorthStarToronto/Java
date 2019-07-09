package Scope;

/* Why restrict access to the field and method
   Top or Member Level
 */
public class AccessModifiers {

//    public int multiplier = 7;
    public static int multiplier = 7;

    public static void main(String[] args) {

        /* Class Access Modifier: Private, Public, & Protected as well as Package Private */
        // Public: Allow any program using the Account class to modify directly
        // Private:
        // Transaction ListMethods should only be modified by the deposit and withdrawl methods
        // Otherwise potential error or fraud
        // Direct access to fields not recommended as it makes it possible to bypass the methods to use those fields
        Account timsAccount = new Account("Tim");
        timsAccount.deposit(1000);
        timsAccount.withdraw(500);
        timsAccount.withdraw(-200);
        timsAccount.deposit(-20);
        //        timsAccount.transactions.add(4500);
        timsAccount.caculateBalance();

        System.out.println("Balance on account is " + timsAccount.getBalance());
        timsAccount.caculateBalance();

        /* Access Control:Top Level and Member Level
           Top Level (class, interface, enums) : Public (object is available to all, even outside the package)
                     Package-private (within only the package) "No access modifiers"
           Member Level: Public, everywhere including outside the package classes
                         Package-private, available to classes in the same package "No access modifiers"
                         Private, available within the class declared
                         Protected, like package-private but visible also in subclasses including different package
         */


        // Static Field = Class Variable
        // Static Method = Access method without use of a classes instance which works on only static fields

        StaticTest firstInstance = new StaticTest("1st Instance");
        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstances()); // firstInstance.getNumInstances()

        StaticTest secondInstance = new StaticTest("2nd Instance");
        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        StaticTest thirdInstance = new StaticTest("3rd Instance");
        System.out.println(thirdInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        // Static field and method belong to the class, not the instance of a class
        // Run a Java Program: Require an entry point
        // Until the program runs no class instances to call methods on
        // Use static main methods => calls from the class name, a class instance x
        // Run .jar => Invokes Java executable => pass the name of the class that contains public static void main method
        // Usually within class named Main => java com.company._static.Main "Easier to look for if hundreds of classes"

        /* Non-static field multiplier cannot be referenced from static context */
//        int answer = multiply(6);
//        System.out.println("Ths answer is " + answer);
//        System.out.println("Multiplier is " + multiplier);

        // Normal class fields require an instance of the class which don't exist until an instance of a class been created
        // Java DO NOT allow static methods to access non-static fields or methods
        /* Nonstatic Instructor => Access static field & method OK */
        /* Static Method => Access non-static filed and method of another class OK "Creates an instance of a class in order to so */
        // Restriction Only on: Static method access on non-static methods and fields on it's own class
    }

//    public int multiply(int number) {
//        return number * multiplier;
//    }

    public static int multiply(int number) {
        return number * multiplier;
    }
}


