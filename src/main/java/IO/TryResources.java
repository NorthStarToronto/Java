package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* A class behaving like a Map but customize it to load its contents from an external source */
/* Implement Various methods of Map => Don't change Main Methods */
// Implement all Map Interface Methods
public class TryResources implements Map<Integer,Location> {

    private static  Map<Integer, Location> locations = new HashMap<Integer, Location>();

    /* Create and Write the data in a file */
    // 2X Type of Exception: Checked (Cannot Ignore) vs Unchecked
    public static void main(String[] args) throws IOException {

        /* Try Resources ensures that writer stream is closed whether the code executes normally or with exception TryResources*/
        try(FileWriter locFile = new FileWriter("locations.txt")) {
            for(Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
            }
        }
//        FileWriter locFile = null; // Create FileWriter Object that can used in all three block scope
//        try{
//            locFile = new FileWriter("locations.txt");
//            for(Location location: locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");  // write the data
//            }
//        } finally { // always executes
//            System.out.println("In catch block");
//            if(locFile!=null) { // Otherwise null point exception
//                System.out.println("Attempting to close locfile");
//                locFile.close(); // close the stream
//            }
//        }
    }

    /* One of static data that's shared among all Locations classes => Initialization block executed when the class is loaded */
//    static {
//        Map<String, Integer> tempExit = new HashMap<String, Integer>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("S", 1);
//        tempExit.put("N", 2);
//        locations.put(5, new Location(5, "You are in the forest", tempExit));
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
