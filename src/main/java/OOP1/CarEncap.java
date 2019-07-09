package OOP1;

/* Java Class by default inherit from Java Object Class */

public class CarEncap extends Vehicle {

    /* Fields unique to CarEncap */
    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;
    private int currentGear;

    public CarEncap(String name, String size, int wheels, int doors, int gears, boolean isManual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.changeGear(): Change to " + this.currentGear + " gear.");
    }

    public void changeVelocity(int speed, int direction) {
        move(speed, direction);
        System.out.println("Car.changeVelocity() : Velocity  " + speed + " direction " + direction);
    }
}
