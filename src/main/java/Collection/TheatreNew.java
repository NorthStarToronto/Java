package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheatreNew {

    private final String theatreName;
    /* Collection<Seat> => new LinkedList(); Any Interface
       Only one level down otherwise cast exception
     */
    private List<Seat> seats = new ArrayList<>();

    // Constructor
    public TheatreNew(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1); // Character ?
        for(char row='A'; row<= lastRow; row++) {
            for(int seatNum=1; seatNum<=seatsPerRow; seatNum++) {
                double price = 12.00;

                if((row < 'D') && (seatNum >=4) && (seatNum <=9)) {
                    price = 14.00;
                } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price); // Constructor
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0); // Create requested seat
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null); // if Collection<Seat> => Error
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }

    public void getSeats() {
        for(Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    /* Nested Class */
    public class Seat implements Comparable<Seat>{

        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        /* */
        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return  seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }
}
