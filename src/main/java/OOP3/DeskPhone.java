package OOP3;

/* Interface => Implements */
// All appropriate methods and parameters
public class DeskPhone implements Telephone {

    private int myNumber;
    private boolean isRinging;

    // Create constructor
    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }

    // Must implement all methods, including unused ones
    @Override
    public void powerOn() {
        System.out.println("No action taken, desk phone does not have a power button");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now rining " + phoneNumber + " on the deskphone");
    }

    @Override
    public void answer() {
        if(isRinging) {
            System.out.println("Answering the desk phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber) {
            isRinging = true;
            System.out.println("Ring ring");
        } else {
            isRinging = false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
