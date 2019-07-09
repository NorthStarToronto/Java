package OOP3;


/* Abstract Class */
// Inteface: Only Method Definition Allowed
// Abstract: Mixed

public class Dog extends Animal {

    public Dog(String name) {
        super(name); // default animal class
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating"); // calling getName from Animal
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, breathe out, repeat");
    }
}
