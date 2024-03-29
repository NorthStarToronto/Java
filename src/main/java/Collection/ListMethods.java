package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListMethods {
    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian", 8, 12);

        /* Shallow Copy: Putting theatre.seats "shared object" */
        // Two separate lists each containing reference to the object
        List<Seat> seatCopy = new ArrayList<>(theatre.seats); // List<Theatre.seat> seatCopy = new Theatre(theatre.seats); nested class
        printList(seatCopy);

        seatCopy.get(1).reserve();
        if(theatre.reserveSeat("A02")) {
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }

        Collections.shuffle(seatCopy); //.shuffle(List<T> list);
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theater.seats");
        printList(theatre.seats);

        Seat minSeat = Collections.min(seatCopy); // Does not need to be sorted
        Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);
    }


    public static void printList(List<Seat> list) {
        for(Seat seat: list) {
            System.out.println(" " + seat.getSeatNumber());
        }

        System.out.println();
        System.out.println("=================================================");
    }

    /* Bubble Sort */
    // sort Generic Type List implementing comparable interface
    public static void sortList(List<? extends Seat> list) {
        for(int i=0;i<list.size(); i++) {
            for(int j=i+1;j<list.size(); j++) {
                if(list.get(i).compareTo(list.get(j))>0) {
                    Collections.swap(list,i, j);
                }
            }
        }
    }

}
