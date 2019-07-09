package OOP3;

/* Interface: Abstract common behaviour that can be used by several classes
   => Standardize a particular set of classes
   => Only supply the actual method names and the parameters
   vs Public Method: A commitment/contract where method signatures and variables will not change
 */

/* Java Libarary uses Interface extensively => Changing LinkedList to List won't break the code */
// List : Public Interface/Contract
// List<Song> playList = new Vector<Song>();
// Generic List as Type => Actual Type when you initialize it

/* Inheritance vs Interface */
// Mobile Phone = Phone Extension + Computre "Interface"
// Inheritance => Only 1X
// Interface => Multiple X

public class Interface {

    public static void main(String[] args) {

        /* Interface cannot be instantiated => Abstract Level Signature */
        Telephone timsPhone; // Telephone timsPhone = new Telephone(123456); X
        timsPhone = new DeskPhone(123456);
        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();

        /* If Telephone timsPhone =>< DeskPhone timsPhone "Incompatiable Error"
           when timsPhone = new MobilePhone(24565);
           Different object/class but Implement the Same interface O
        */

        timsPhone = new MobilePhone(24565);
        // timsPhone.powerOn();
        timsPhone.callPhone(24565);
        timsPhone.answer();
    }
}
