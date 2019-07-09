package OOP3;

/* Interface always Public */
public interface Telephone {

    /* Creating Signatures:
       Define only the parameters, the name, and the return type
       Defining only the method
       Actual code is implemented in the inheriting class
       Only Defining the Contract
    */

    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();
}
