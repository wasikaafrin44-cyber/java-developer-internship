package com.codeveda.level1;

import java.util.Scanner;

public class FactorialMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number.");
        int num = sc.nextInt();

        if (num < 0) {

            System.out.println("Factorial is not possible for " + num);
        }else{
            int result=factorial(num);
            System.out.println(result);
        }
    }
        public static  int factorial(int num){
            if(num == 0 || num == 1){
                return 1;
            }else{
                return num * factorial(num -1);
            }
    }

}

