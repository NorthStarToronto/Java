package OOP4;

/* Using Generics => Cleaner Code & Easy to debug */
public class GenericsChallenge {

    public static void main(String[] args) {

        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");

    }
}
