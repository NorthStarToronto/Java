package IO;

/*
 Input: Reading data from source
 Output: Writing to a destination
 e.g. files, network connection, pipes
 Byte (Binary) or Character Data (Text Editor)
 Serial/Sequential File vs Random Access File (Jump on
 */
// => Different Class but similar methods
// e.g. Stream object to handle stream data

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Files & Directory
public class Main {

    private static Locations locations = new Locations();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("Quit", "Q");
        vocabulary.put("North", "N");
        vocabulary.put("South", "S");
        vocabulary.put("East", "E");
        vocabulary.put("West", "W");

        int loc =1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if(loc==0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exists are ");
            for(String exit : exits.keySet()) {
                System.out.println(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if(direction.length()>1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }


            if(exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
