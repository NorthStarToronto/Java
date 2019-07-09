package OOP4;

import java.util.ArrayList;

public interface Saveable {

    ArrayList<String> write();
    void read(ArrayList<String> savedValues);

}
