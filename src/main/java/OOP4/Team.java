package OOP4;

import java.util.ArrayList;

/* Indicate Type in Class */
// public class Team<T> {
// Type parameter accepted for Team class when using generics
// any class extending from player or subclass of player
// Player upper bound of T

// Implement Comparable using same Generic T
// Compare Teams
// Specify a generic type as a parameter
// to the generic interface comparable => Implement Method compare to
// Compare out team to other teams
// Use Team Type and <T> for apple to apple comparison
// 2X types: <Team> & <Team Football Player>

// Compare Football Team to Football Team
public class Team<T extends Player> implements Comparable<Team<T>> {

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /* Make generic => work for any type of player */
    // addPlayer(Player player) => addPlayer(T player)
    // Player abstract class definition => can pass
    // Upon Class Instantiation T will be replaced by actual actual class
    public boolean addPlayer(T player) {
        if(members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
//            System.out.println(((Player) player).getName() + " is already on this team"); // Cast to Player Object
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + "picked for the team " + this.members);
//            System.out.println(((Player player).getName() + " picked for the team " + this.members);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    // Use generic type which was defined in the class constructor before
    // Compare baseball team to baseball team
    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {

        String message;

        if(ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if(ourScore == theirScore) {
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if(opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()) {
            return -1;
        } else if(this.ranking()< team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
