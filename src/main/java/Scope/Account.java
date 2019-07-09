package Scope;

import java.util.ArrayList;
public class Account {
    // create fields
    private String accountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    // create constructor & initialize fields
    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<Integer>();
    }

    // create getter
    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if(amount>0) {
            this.transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " withdrawn. Balance is now " + this.balance);
        } else {
            System.out.println("Cannot with draw negative sums");
        }
    }

    public void withdraw(int amount) {
        int withdrawl = -amount;
        if(withdrawl < 0) {
            this.transactions.add(withdrawl);
            this.balance += withdrawl;
        } else {
            System.out.println("Cannot withdraw negative sums");
        }
    }

    public void caculateBalance() {
        this.balance = 0;
        for(int i: this.transactions) {
            this.balance += i;
        }
        System.out.println("Calculated balance is " + this.balance);
    }
}
