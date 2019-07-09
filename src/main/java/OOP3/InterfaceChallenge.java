package OOP3;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceChallenge {


    public static void main(String[] args) {

        Player tim = new Player("Tim", 10 ,15);
        System.out.println(tim.toString());
        saveObject(tim);

        tim.setWeapon("Stormbringer");
        saveObject(tim);
//        loadObject(tim);
        System.out.println(tim);

        /* Access to the Actual Implementation Class's Methods */
        Saveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println("Strength = " + (((Monster) werewolf).getStrength()));

        Monster werewolf1 = new Monster("Werewolf1", 30,100);
        werewolf1.getStrength();
        System.out.println(werewolf);
        saveObject(werewolf);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index=0;

        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while(!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    /* By passing in Saveable Interface => Save any object with Saveable Interface possible */
    public static void saveObject(Saveable objectToSave) {
        /* Loop through ArrayList which is returned from write method */
        for(int i=0; i<objectToSave.write().size(); i++) {
            System.out.println("Saving " +objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(Saveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
