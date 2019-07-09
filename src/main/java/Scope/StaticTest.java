package Scope;

/* Static Methods and Fields belong to the Class */
public class StaticTest {
    private static int numInstances = 0;
    private String name;

    public StaticTest(String name) {
        this.name = name;
        numInstances++;
    }

    /* A method that only works on static fileds => Declare Method Static */
    public static int getNumInstances() {
        return numInstances;
    }

    public String getName() {
        return name;
    }
}
