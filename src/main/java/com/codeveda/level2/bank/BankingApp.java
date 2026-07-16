package com.codeveda.level2.bank;

import java.util.Scanner;

public class BankingApp{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter an account number: ");

        String accountNum=sc.nextLine();

        System.out.println("Enter Name: ");
        String name=sc.nextLine();

        System.out.println("Balance: ");
        double bal=sc.nextDouble();

        BankAccount ac=new BankAccount(accountNum, name, bal);

        int choice;

        do {
            System.out.println("\n banking menu: ");
            System.out.println("1.Deposit: ");
            System.out.println("2.withdraw:  ");
            System.out.println("3.check balance: ");
            System.out.println("4.Banking detailts: ");
            System.out.println("5. Exit");
            System.out.println("Enter a choic: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit: ");
                    double depo = sc.nextDouble();
                    ac.deposit(depo);
                    break;

                case 2:
                    System.out.println("Enter amount to withdraw: ");
                    double with = sc.nextDouble();
                    ac.withdraw(with);
                    break;

                case 3:
                    System.out.println("Check Balance: ");
                    ac.checkBalance();
                    break;

                case 4:
                    System.out.println("Details:");
                    ac.displayDetails();
                    break;

                case 5:
                    System.out.println("Thanks for tasking the banking service..");

                default:
                    System.out.println("Invalid choice!! Try again.");
            }
        }
            while(choice !=5);
                sc.close();


    }
}
