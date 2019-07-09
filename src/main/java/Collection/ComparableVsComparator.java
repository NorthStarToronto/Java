package Collection;

/* Collections Sort Methods require Comparable & Comparator Interfaces */
// Comparator: Consistent with equals X
public class ComparableVsComparator {

    public static void main(String[] args) {

        TheatreNew theatreNew = new TheatreNew("Olympian", 8, 12);

        if(theatreNew.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already reserved");
        }

        if(theatreNew.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat already reserved");
        }
    }


}
