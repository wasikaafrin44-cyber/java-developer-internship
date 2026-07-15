package com.codeveda.level1;

import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {

      Scanner sc= new Scanner(System.in);
      Calculator cal=new Calculator();

        System.out.println("***Basic Calculator***");

        System.out.println("Enter First number: ");
        double num1=sc.nextDouble();

        System.out.println("Enter Second number: ");
        double num2=sc.nextDouble();

        System.out.println("\nChoose Operation:");

             System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");

        System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
        System.out.println("Enter your choice: ");
        int choice=sc.nextInt();

        try{
            double result;

            switch (choice){
                case 1:

                    result=cal.add(num1,num2);
                    System.out.println("Add: "+result);

                    break;

                case 2:
                    result=cal.subtract(num1,num2);
                    System.out.println("Subtraction: "+result);
                    break;

                case 3:
                    result=cal.multiply(num1,num2);
                    System.out.println("Multiply: "+result);
                    break;

                case 4: result=cal.divide(num1, num2);
                    System.out.println("Divided: "+result);
                    break;

                default:
                    System.out.println("Invalid");
            }

        }catch (ArithmeticException e){
            System.out.println("Error");
        }
        sc.close();
    }
}