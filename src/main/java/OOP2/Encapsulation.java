package OOP2;


/* Encapsulation: Restrict access to certain components you are creating => protect the members of
   a class from external access "More control and Easy Change"
   Private & Constructor & Initialization
 */
public class Encapsulation {

    public static void main(String[] args) {
        /* Encapsulation : Restrict access to certain components / protect external access */

        /* Bad example => Manual Constructor */
        Player player = new Player();
        player.name = "Tim"; // change the name in the player than also change here
        player.hitPoints = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Player remaining hitPoints " + player.healthRemaining());

        /* The Proper Example */
        EnhancedPlayer player1 = new EnhancedPlayer("TIm", 200, "Sword");
        System.out.println("Initial Health is " + player1.getHealth());
    }
}