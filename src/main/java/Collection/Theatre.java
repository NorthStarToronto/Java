package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Theatre {

    private final String theatreName;
    /* Collection<Seat> => new LinkedList(); Any Interface
       Only one level down otherwise cast exception
     */
    public List<Seat> seats = new ArrayList<>();

    // Constructor
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1); // Character ?
        for(char row='A'; row<= lastRow; row++) {
            for(int seatNum=1; seatNum<=seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber); // Create requested seat
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null); // if Collection<Seat> => Error
        if(foundSeat>=0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }


//        for(Seat seat : seats) {
//            if(seat.getSeatNumber().equals(seatNumber)){
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if(requestedSeat==null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//
//        return requestedSeat.reserve();
    }

    public void getSeats() {
        for(Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }
}
