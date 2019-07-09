package OOP2;

/* Polymorphism: Method or Mechanism that allows actions to act differently based on object action is being performed */
/*
  Write generic code => Otherwise, switch class name (equal = ) then call particular method

 */
public class Polymorphism {

    public static void main(String[] args) {

        for(int i=0; i<11; i++) {
            Movie movie = randomMovie();
            System.out.println("Movie #" + i +
                                ":" + movie.getName() + "\n" +
                                "Plot: " + movie.plot() + "\n");
        }
    }

    // Create a method returning a random Movie
    public static Movie randomMovie() {
        int randomNumber = (int) (Math.random() * 5) + 1; // Between 0 & 1 => random returns double
        System.out.println("Random number generated was: " + randomNumber);

        switch (randomNumber) {
            case 1:
                return new Jaws();
//                    break; redundant
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new Forgetable();
            default:
                return null;
        }
//        return null;
    }
}

/* Base Class */
class Movie {

    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}


class Jaws extends Movie {

    public Jaws() {
        super("Jaws"); // initialize using parent constructor
    }

    @Override
    public String plot() {
        return "A shark sets lots of people";
    }
}

class IndependenceDay extends Movie {

    public IndependenceDay() {
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "Aliens attempt to take over the planet earth";
    }
}

class MazeRunner extends Movie {

    public MazeRunner() {
        super("MazeRunner");
    }

    @Override
    public String plot() {
        return "Kds try to escape";
    }
}

class StarWars extends Movie {

    public StarWars() {
        super("Starswar");
    }

    @Override
    public String plot() {
        return "Imperial Forces attack ...";
    }
}

class Forgetable extends Movie {

    public Forgetable() {
        super("Forgetable");
    }
    // no plot method
}


