package Collection;


/* Framework
   => Top Level: Collection Class: Static Method operations
   => Interface: Framework Extension & Define Methods for all fundamental operations e.g. List Interface
   => Aggregate Opertions
   => Algorithm
 */
public class Main {

    public static void main(String[] args) {

        /* Create Theatre and Reserve Seats */
        Theatre theatre = new Theatre("Olympian", 8, 12);
        theatre.getSeats();

        if(theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        if(theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

    }
}
