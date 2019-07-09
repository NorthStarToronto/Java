package OOP1;

public class Account {
    private String number;
    private double balance;
    private String customerName;
    private String customerEmailAddress;
    private String customerPhoneNumber;


    // Empty Constructor with default values
    // Do not call other methods in a constructor
    public Account() {
        this("12555", 2.50, "Default Name", "Default Address", "Default Phone");
        System.out.println("Empty constuctor called");
    }


    public Account(String customerName, String customerEmailAddress, String customerPhoneNumber) {
        this("99999", 100.55, customerName, customerEmailAddress, customerPhoneNumber);
    }

    // Overloading Constructor "Main Initialization Constructor"
    public Account(String number, double balance, String customerName, String customerEmailAddress, String customerPhoneNumber) {
        System.out.println("Account constructor with parameters called ...");
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void deposit(double depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + "mad. New Balance is " + this.balance);
    }

    public void withdrawl(double withdrawlAmount) {
        if(this.balance - withdrawlAmount < 0) {
            System.out.println("Only " + this.balance + "available. Withdrawl not processed");
        } else {
            this.balance -= withdrawlAmount;
            System.out.println("Withdrawl of " + withdrawlAmount + " processed. Remaining balance = " + this.balance);
        }

    }

    // Getter & Setter vs Constuct Initialization

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }




}
