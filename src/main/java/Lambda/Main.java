package Lambda;

import org.omg.PortableServer.THREAD_POLICY_ID;
import sun.awt.windows.ThemeReader;

import javax.print.DocFlavor;
import java.util.*;

/* Interface with one method */
// Pass the one line statement into thread constructor without extra lines
// Lambda expression can only be used with interface that contain only one method to be implemented
// Functional1 Interface

public class Main {

    public static void main(String[] args) {

        // Lambda
        new Thread(()-> {
            System.out.println("Lambda ");
            System.out.println("Second ");
            System.out.println("Third");
        }).start();
//
//        // Use Runnable object to create and run a thread
//        new Thread(new CodeToRun()).start();
//
//
//        // Anonymous Class
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing ... ");
//            }
//        })

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Cook", 23);
        Employee jack = new Employee("Jack Welch", 56);
        Employee snow = new Employee("Snow Mary", 18);

        // Lambda for interface with one method implementation

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

//        // Anonymous Class
//        Collections.sort(employees, new Comparator<Employee>() {
//            // Implement compare method
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName()); // -1, 0, 1
//            }
//        });

        /* Pass lambda as second parameter */
        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName())); // infer types
//        Collections.sort(employees, (Employee employee1, Employee employee2) ->
//                employee1.getName().compareTo(employee2.getName()));


        // Print in ascending order
        for (Employee employee: employees) {
            System.out.println(employee.getName());
        }

        /* All classes descend from object => object contains an equal method */
        // Comparator interface has only one single method to be implemented
        // Functional1 interface => we can use lambda instead of anonymous class

        /* Parameters 3X: Anonymous Class, first element in employees list, second ~*/
        String sillyString1 = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        },
        employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString1);

        /* Lambda */
        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        String sillyString2 = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString2);

        /* */
    }

    // Method accepts an object that implements upper concat and two strings
    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }

}


// Implement Runnable
class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the Runnables");
    }
}



/* Add an interface */
interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}


class AnotherClass {

    public String doSomething() {
        /* Anonymous instance is not created; Lambda is treated like a nest block of code */




        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1", "String2");
    }
}