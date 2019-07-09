package Scope;

/* Scope: The visibility of a class, member, or variable e.g. Walmart Discount
   Refer to the variable available in the current scope
   Limited by access modifiers public, private, & protected
   => Refer to the variable within the most local scope
   "The Rule of Scope" => The variable with the narrow scope is the one used
   "Enclosing blocks"
   => Starts by checking the current block code for variable declaration
   => If not than any blocks that encloses the current block => backward
 */

import java.util.Scanner;

public class Main {

    public static int multiplier = 7;

    public static void main(String[] args) {
        String varFour = "this is private main()";

        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.useInner();
        System.out.println("scopeInstance varOne is " + scopeInstance.getVarOne()); // variable created by the constructor
        System.out.println(varFour); // local variable to the main method

        scopeInstance.timesTwo();
        System.out.println("****************");
        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timeTwo();
//        System.out.println("varThree is not accessible here " + innerClass.varThree); => Error
        // varThree got private access => no visibility outside its class or a containing class

        /* varOne & varThree's visibility within ScopeCheck is related to the scope of the variables */
        /* Declared Private But Can be accessed from both the outer and inner classes */
    }
}