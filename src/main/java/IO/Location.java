package IO;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final LinkedHashMap<String, Integer> exits; // Guarantee Order

    public Location(int locationID, String description, HashMap<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new LinkedHashMap<String, Integer>(exits);
        this.exits.put("Q", 0);
    }



//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits); // return new exits
    }

    /* Available only to the current package */
    protected void addExit(String direction, int location) {
        exits.put(direction, location);
    }
}
