package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Functional2 {

    public static void main(String[] args) {

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

        // Functionl Method: apply
        /* Function Interface: One Input Parameter and Return A value ``*/
        // run the code on input
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        // Create a interface and the class that implements it
        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        // Lambda expression with anonymous class
        employees.forEach(employee -> {
            String lastName1 = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println("Last Name is : " + lastName);
        });

        Employee employee1 = employees.get(1);
        getLastName(employee1);

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0,employee.getName().indexOf(' '));
        };

        Random random = new Random();
        for(Employee employee : employees) {
            if(random.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        // Set of situations 30 lines of code only two line of code  will vary
        // Pass in functions for the parts that vary
        // Easy and Concise

        // Callback

        // Transforn an object: Four Steps for each step
        // One: 3 algorithm
        // Two: 2
        // Three: 5
        // Four: 4 => Total 3x2x5x5 = 120 variations
        // Write four functions and 13 funcitons to use to transform the object
        // easier conventinet scalable

    }

    private  static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    //Regular Old Public Static Method
    public static void getLastName(Employee employee) {
        System.out.println("WOw");
    }


}


