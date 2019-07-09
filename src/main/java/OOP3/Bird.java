package OOP3;

/* Abstract class extending from another abstract class */
public abstract class Bird extends Animal implements CanFly {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is packing");
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, ... breathe out ...");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is fling");
    }
}
