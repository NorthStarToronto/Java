package IO;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

/* BufferedReader: read texts from the input stream(file reader) and buffers the characters into a character array */
// Reading few characters => chunks of data "More Efficient"
public class BufferReader implements Map<Integer,Location> {

    private static  Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    /* Create and Write the data in a file */
    // 2X Type of Exception: Checked (Cannot Ignore) vs Unchecked
    public static void main(String[] args) throws IOException {

        /* Try Resources ensures that writer stream is closed whether the code executes normally or with exception TryResources*/
        try(BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
            BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
            for(Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for(String direction: location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q")){
                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
        }
    }

    /* One of static data that's shared among all Locations classes => Initialization block executed when the class is loaded */
//    static {
//        // Try resources
//        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations.txt")))) {
//            scanner.useDelimiter(","); // comma delimiter
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter()); // skip over comma
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        /* Read the exits: FileReader passed to Buffer Reader Constructor */
//        // Closing Scanner => Close BufferedReader because it implements close interface
//
//        /* Change scanner => Buffer Reader */
//        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions.txt"))) {
//            String input;
//            while ((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
