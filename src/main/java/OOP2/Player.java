package OOP2;

public class Player {

    public String name;
    public int hitPoints;
    public String weapon;

    public void loseHealth(int damage) {
        this.hitPoints = this.hitPoints - damage;
        if(this.hitPoints <= 0) {
            System.out.println("Player knocked out");
        }
    }

    public int healthRemaining() {
        return this.hitPoints;
    }
}
