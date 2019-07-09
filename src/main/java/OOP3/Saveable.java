package OOP3;

import java.util.ArrayList;
import java.util.List;

public interface Saveable {

    /* 2X Methods to be implemented */

    // For maximum flexibility use Generic List Type
    List<String> write();
    void read(List<String> savedValues);
}
