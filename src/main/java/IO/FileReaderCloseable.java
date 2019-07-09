package IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/* A class behaving like a Map but customize it to load its contents from an external source */
/* Implement Various methods of Map => Don't change Main Methods */
// Implement all Map Interface Methods
public class FileReaderCloseable implements Map<Integer,Location> {

    private static  Map<Integer, Location> locations = new HashMap<Integer, Location>();

    /* Create and Write the data in a file */
    // 2X Type of Exception: Checked (Cannot Ignore) vs Unchecked
    public static void main(String[] args) throws IOException {

        /* Try Resources ensures that writer stream is closed whether the code executes normally or with exception TryResources*/
        try(FileWriter locFile = new FileWriter("locations.txt");
            FileWriter dirFile = new FileWriter("directions.txt")) {
            for(Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for(String direction: location.getExits().keySet()){
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }
    }

    /* One of static data that's shared among all Locations classes => Initialization block executed when the class is loaded */
//    static {
//        Scanner scanner = null; // scope expand to all blocks
//        try{
//            scanner = new Scanner(new FileReader("locations.txt"));
//            scanner.useDelimiter(","); // comma delimiter
//            while(scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter()); // skip over comma
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//
//        } catch(IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(scanner != null) {
//                scanner.close();
//            }
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
