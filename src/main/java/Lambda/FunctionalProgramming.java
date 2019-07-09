package Lambda;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

import static Lambda.TextColor.*;

/*
  Functional Programming Example
  The full business process,
  e.g. data collection through API(3X: Mobile, Web, POS)
       => text data transformation (2X: JSON, CSV)
       => business insight aggregation (2X Sum, Average)

  Minimum Coding Objects/Tasks with OOP Abstraction = 3x2x2 = 12X "Curse of Dimensionality"
  => 12 Different long lines of scripts required.

  ---------------------------------------------------------------------------------------------------------
  With functional programming
  Only 1X long lines of code
  With 3 functions(3 business steps) and 12 transform functions(12 variations)
  Using functional programming's syntax sugar and call back ability (pass function and data to function)
  ---------------------------------------------------------------------------------------------------------
  => Concise, Easily Maintained, and Scalable Programming
 */

public class FunctionalProgramming {
    public static void main(String[] args) {
        Customer peter = new Customer("Peter Parker", 51);
        Customer mary = new Customer("Mary Jane", 35);
        Customer john = new Customer("John Doe", 17);
        Customer jane = new Customer("Jane Doe", 24);

        ArrayList<Customer> customers = new ArrayList<>();

        customers.add(peter);
        customers.add(mary);
        customers.add(john);
        customers.add(jane);


        /* Function Interface Implementation in the Main Method: Generic Class Input(Primitive Type X) , Generic Class Return,
           & the Code to run on the input */

        // getLastName Function Interface Implementation
        Function<Customer, String> getLastName = (Customer customer) -> {
            return customer.getName().substring(customer.getName().indexOf(' ') + 1);
        };

        // getFirstName Function Interface Implementation
        Function<Customer, String> getFirstName = (Customer customer) -> {
            return customer.getName().substring(0, customer.getName().indexOf(' '));
        };

        // getAge Function Interface Implementation
        Function<Customer, String> getAge = (Customer customer) -> {
            return Integer.toString(customer.getAge());
        };


        Random random = new Random();
        for (Customer customer : customers) {
            int apiType = random.nextInt(3);
            if (apiType==0) {
                System.out.println(ANSI_GREEN + "Customer's First Name API Called : " + ANSI_RESET + getAInfo(getFirstName, customer));
            } else if (apiType==1) {
                System.out.println(ANSI_BLUE + "Customer's Last Name API Called : " + ANSI_RESET + getAInfo(getLastName, customer));
            } else  {
                System.out.println(ANSI_CYAN + "Customer's Age API Called : " + ANSI_RESET + getAInfo(getAge, customer));
            }
        }
    }

    // Customer API Recovery Lambda Function
    private  static String getAInfo(Function<Customer, String> getInfo, Customer customer) {
        return getInfo.apply(customer);
    }
}




/*
    public interface ResizeImage {
        public Image resize(Image image);
    }

    public ListMethods<Image> runWhenDone() {
        // pretend we have access to an ImageResizer
        // instance (probably provided when a Runnable object was constructed)


    }
 */