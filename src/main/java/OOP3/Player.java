package OOP3;

import java.util.ArrayList;
import java.util.List;

public class Player implements Saveable {

    // Create fields
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;

    // Create constructor
    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    // Create Getter and Setter Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    // Override toString Method
    @Override
    public String toString() {
        return "Player{" +
                "name='" + this.name + '\'' +
                ", hitPoints=" + this.hitPoints +
                ", strength=" + this.strength +
                ", weapon='" + this.weapon + '\'' +
                '}';
    }

    // Implement Interface Methods
    // Saving player's character
    // And reading it later

    /* Write Method: Insert members variables that are needed to save the player's state "non string => string first */
    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>(); // Flexibility => Any type of list
        values.add(0, this.name);
        values.add(1,"" + this.hitPoints); // convert to string "" +
        values.add(2, "" + this.strength);
        values.add(3, this.weapon);
        return values;
    }

    // Despite parsing ArrayList => Implement ListMethods Interface
    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size() > 0) {
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
            this.weapon = savedValues.get(3);
        }
    }
}
