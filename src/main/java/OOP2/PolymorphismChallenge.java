package OOP2;

public class PolymorphismChallenge {

    public static void main(String[] args) {

        CarPoly car = new CarPoly(8, "Base car"); // Make sure Class matches return and type
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

    }
}

/* Where the code executing => getClass() and getSimpleName() */
class Mitsubishi extends CarPoly {

    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName()+ " -> startEngine()";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName()+ " -> accelerate()";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName()+ " -> brake()";
    }
}
