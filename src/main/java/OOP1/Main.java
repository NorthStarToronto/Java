package OOP1;


/* A new class that inherits from the parent class states i.e. fields & methods */
public class Main {

    public static void main(String[] args) {

        /* Constructor Exercise */
        Car porsche = new Car();
        Car holden = new Car();
        porsche.setModel("Carrera");
        System.out.println("Model is " + porsche.getModel());

        Account tomsAccount = new Account("256666", 0.00, "Tom Selek", "tom@gmail.com", "435 0353535055");

        System.out.println(tomsAccount.getBalance());
        System.out.println(tomsAccount.getCustomerEmailAddress());

        Account bobsAccount = new Account();
//        bobsAccount.setNumber("123435");
//        bobsAccount.setCustomerEmailAddress("bob@gmai.com");
//        bobsAccount.setCustomerName("Bobby");
//        bobsAccount.setCustomerPhoneNumber("(006) 434 - 1234");


        bobsAccount.withdrawl(100.0);

        bobsAccount.deposit(50.0);
        bobsAccount.withdrawl(20.0);

        Account janesAccount = new Account("Jane", "jane@gmail.com", "1234");

        VipPerson person1 = new VipPerson();
        System.out.println(person1.getName());

        VipPerson person2 = new VipPerson("Bob", 25000.00);
        System.out.println(person2.getCreditLimits());

        VipPerson person3 = new VipPerson("Jason", 30000.00, "jason.gmail.com");
        System.out.println(person3.getName());


        /* Inheritance Exercise */
        Animal animal = new Animal("Animal", 1, 1, 5, 5);

        Dog dog = new Dog("Yorkie", 8, 20, 2,4,1,20, "Long Silky");
        dog.eat();
        dog.run();


    }
}
