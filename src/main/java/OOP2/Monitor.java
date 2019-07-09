package OOP2;

public class Monitor {

    private String model;
    private String manufacturer;
    private int size;
    private Resolution nativeResoluation;

    public Monitor(String model, String manufacturer, int size, Resolution nativeResoluation) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.nativeResoluation = nativeResoluation;
    }

    // public method
    public void drawPixel(int x, int y, String color) {
        System.out.println("Drawing pixel at " + x + "," + y + "in colour " + color);
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSize() {
        return size;
    }

    public Resolution getNativeResoluation() {
        return nativeResoluation;
    }
}
