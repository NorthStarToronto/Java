package IO;

import java.io.*;
import java.util.*;

/* Read and write text files/data => Reduce Disk Access Time => Read Large Chunks to the memory/Write to Buffer */
// Byte stream can read and write any of Java primitive types
// Use InputStream and Output Stream Classes "Handle Only Raw Byte"

public class ByteStreams implements Map<Integer,Location> {

    private static  Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    /* Create and Write the data in a file */
    // 2X Type of Exception: Checked (Cannot Ignore) vs Unchecked
    public static void main(String[] args) throws IOException {

    }

    /* One of static data that's shared among all Locations classes => Initialization block executed when the class is loaded */
    static {

    }

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
