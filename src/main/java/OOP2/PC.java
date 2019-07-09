package OOP2;

public class PC {

    private Case theCase;
    private Monitor montior;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor montior, Motherboard motherboard) {
        this.theCase = theCase;
        this.montior = montior;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        this.theCase.pressPowerButton(); // getTheCase().pressPowerButton()
        drawLogo();
    }

    private void drawLogo() {
        montior.drawPixel(1200, 50, "yellow");
    }

//    Getter May be required for object validation
//    public Case getTheCase() {
//        return theCase;
//    }
//
//    public Monitor getMontior() {
//        return montior;
//    }
//
//    public Motherboard getMotherboard() {
//        return motherboard;
//    }
}
