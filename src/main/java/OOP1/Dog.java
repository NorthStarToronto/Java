package OOP1;

public class Dog extends Animal {
    // Unique Dog Characteristics
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    // Basic Constructor
    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, 1, size, weight); // initializing using parent constructor
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    // Unique dog method
    private void chew() {
        System.out.println("Dog.chew() called");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }

    public void walk() {
        System.out.println("Dog walk() called");
        super.move(5);
    }

    /* super.move() vs move => if dog.move() does not exist than search for the method in the parent class */
    public void run() {
        System.out.println("Dog.run() called");
        move(10);
    }

    private void moveLegs(int speed) {
        System.out.println("Dog.moveLegs() called");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }
}
