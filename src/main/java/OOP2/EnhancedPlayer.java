package OOP2;

public class EnhancedPlayer {

    private String name;
    private int health = 100; // Default value
    private String weapon;

    /* One Constructor => Guarantee initialization of fields */
    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;

        if (this.health > 0 && this.health <- 100) {
            this.health = health;
        }

        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.health = this.health - damage;
        if (this.health <=0) {
            System.out.println("Player knocked out ...");
        }
    }

    public int getHealth() {
        return this.health;
    }
}
