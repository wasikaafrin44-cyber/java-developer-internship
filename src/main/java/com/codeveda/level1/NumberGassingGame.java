package com.codeveda.level1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGassingGame {

    public void game() {
        Random random = new Random();

        Scanner sc = new Scanner(System.in);
        System.out.println("*** Guess a number***");

        int randomNumber = random.nextInt(100) + 1;

        int maxAttempt = 5;


        int attempt = 0;


        while (attempt < maxAttempt) {
            try {

                System.out.println("Enter a number between 1 and 100");

                int guessingNum = sc.nextInt();

                if (guessingNum == randomNumber) {
                    System.out.println(" Congratulations!! You guessed the actual number...");
                    return;
                } else if (guessingNum > randomNumber) {
                    System.out.println("Too High...");
                } else {
                    System.out.println("Too LOw...");
                }

                attempt++;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!Please enter a number. ");
                sc.next();
            }

        }


        System.out.println("Game is over..!!Thanks for playing..");
        System.out.println("The correct number is " + randomNumber);

    }
}
