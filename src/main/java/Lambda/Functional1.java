package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functional1 {

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

        for(Employee employee : employees) {
            if(employee.getAge()>30) {
                System.out.println(employee.getName());
            }
        }


        /* Predicate: Return true or false */
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        printEmployeesByAge(employees,"Employee over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees,"\nEmployee under 30", employee -> employee.getAge() < 30);
        printEmployeesByAge(employees, "Employee under 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.and(lessThan100).test(45));

        /* Supplier: No parameter */
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i=0;i<10; i++) {
//            System.out.println(random.nextInt(1000));
            System.out.println(randomSupplier.get());
        }

    }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("============");
        for(Employee employee: employees) {
            if(ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
