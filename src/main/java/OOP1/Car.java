package OOP1;

public class Car {

    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;


    // Invalid Object Creattion Filtering => Testing within the Class


    // Setter Method
    public void setModel(String model) {

        // Testing
        String validModel = model.toLowerCase();
        if(validModel.equals("carrera") || validModel.equals("commodore")) {
            this.model = model;
        } else {
            this.model = "unknown";
        }
    }

    // Getter Method
    public String getModel() {
        return this.model;
    }
}


