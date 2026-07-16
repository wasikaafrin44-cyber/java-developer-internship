package com.codeveda.level2.bank;

public class BankAccount {
    private String accountHolder;

    private String accountNumber;

    private double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;

            System.out.println("Deposit amount: $" + balance);
        } else {
            System.out.println("Invalid deposite amount!!");
        }
    }


    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            System.out.println("withdraw amount: " + amount);

            balance -= amount;
        } else if (amount > balance) {
            System.out.println("Insufficient funds!!");
        } else {
            System.out.println("Invalid withdraw amount!!");
        }
    }


    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public void displayDetails() {
        System.out.println("Account  number: " + accountHolder);
        System.out.println(" Account holder name: " + accountNumber);
        System.out.println("Balance $" + balance);

    }
}