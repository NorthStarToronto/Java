package OOP2;

public class Printer {

    private int tonnerLevel;
    private int pagesPrinted;
    private boolean duplex;

    /* Field Validation done inside the constructor */
    public Printer(int tonnerLevel, boolean duplex) {
        if(tonnerLevel >-1 && tonnerLevel <=100) {
            this.tonnerLevel = tonnerLevel;
        } else {
            this.tonnerLevel = -1;
        }


        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonnerAmount) {
        if(tonnerAmount >0 && tonnerAmount<=100) {
            if(this.tonnerLevel + tonnerAmount > 100) {
                return -1;
            } else {
                this.tonnerLevel += tonnerAmount;
                return tonnerLevel;
            }
        } else {
            return -1;
        }
    }

    public int printPages(int pages) {
        int pagesToPrint = pages;
        if(this.duplex) {
            pagesToPrint = pages/2 + pages %2;
            System.out.println("Printing is duplex mode");
        }
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
