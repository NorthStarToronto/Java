package OOP4;

/* Generics: Create classes that takes types as parameters for the method */
// Early debugging cheaper
// Don't use raw type
// Ensure that we don't produce a program that compiles

import java.util.ArrayList;

public class Generics {

    public static void main(String[] args) {
     /*   ArrayList times*/
        // ArrayList = A Generic Type
        // Must specify a type parameter using <>
        // explicit => diamond <>
        ArrayList<Integer> items = new ArrayList<>() ; // parameterized type
        items.add(1); // auto-boxing primitive type to Integer class
        items.add(2);
        items.add(3);
        items.add(4);
        items.add(5);

        printDoubled(items);

        /* Generic */
        FootballPlayer footballPlayer = new FootballPlayer("Joe");
        BaseballPlayer baseballPlayer = new BaseballPlayer("Pet");
        SoccerPlayer soccerPlayer = new SoccerPlayer("Beckham");

        // Team with Type Argument
        // Property assignment about generic class
        // Instead of creating 3X types of team
        Team<FootballPlayer> adelaideCrows = new Team<>("Addel"); // adelaideCrows will only accept FootballPlayer
        adelaideCrows.addPlayer(footballPlayer);
//        adelaideCrows.addPlayer(baseballPlayer);
//        adelaideCrows.addPlayer(soccerPlayer);

        Team<BaseballPlayer> cubs = new Team<>("cubs"); // Define a tema of type Bas
        cubs.addPlayer(baseballPlayer);

        Team<SoccerPlayer> eagles = new Team<>("eagles");
        eagles.addPlayer(soccerPlayer);

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2,1);
//        adelaideCrows.matchResult(cubs, 1,1);

        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ":" + adelaideCrows.ranking());
        System.out.println(adelaideCrows.compareTo(hawthorn));

        System.out.println(adelaideCrows.numPlayers());

        // Efficient coding => Avoid duplicate coding
        // Modify the team to be a generic class

        /* Key Considerations for Generic Class */
    }

    // case primitive type to Integer object
    private static void printDoubled(ArrayList<Integer> n) {
        // Autoboxing convert automatically from Integer Class to int
        for (int i : n) { // Object i : n
            System.out.println( i * 2);
//            System.out.println((Integer) i * 2); // type of object in ArrayList Integer
        }
    }
}
