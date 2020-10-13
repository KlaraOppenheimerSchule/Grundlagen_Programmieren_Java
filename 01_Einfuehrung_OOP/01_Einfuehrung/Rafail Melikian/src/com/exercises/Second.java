package com.exercises;

import java.util.Scanner;

public class Second {
    public int numberAddierer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First number: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Second number:");
        int secondNumber = scanner.nextInt();
        return firstNumber + secondNumber;

    }
    public int numberSquare() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number to put in square: ");
        return (int)Math.pow(scanner.nextInt(), 2);
    }
    public boolean numberBoolean() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number for check: ");
        int numberToCheck = scanner.nextInt();
        return numberToCheck >= 0;
    }
    public static void main(String[] Args) {
        Second numberCount = new Second();
        System.out.println(numberCount.numberAddierer());
        System.out.println(numberCount.numberSquare());
        System.out.println(numberCount.numberBoolean());
    }
}