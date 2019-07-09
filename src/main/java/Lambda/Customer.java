package Lambda;

/* Object Oriented Programming for Java
   1) Safe:
      Object(customer) information(name & age) access(read & write) is controlled (use getters and setters for private fields)
   2) Reusable & Scalable :
      Only need to type abstract code for REST API calls
      e.g. POST - Customer firstCustomer = new Customer("Peter Parker", 28)
   3) Synchronization/Asynchronization(Bank vs Retail?) :
      Systematic management of resources(CPU or Cluster memories)
      for efficient(faster execution of tasks/applications) and effective usage(Heap memory sharing & Stack memory owning)
 */

public class Customer {

    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
