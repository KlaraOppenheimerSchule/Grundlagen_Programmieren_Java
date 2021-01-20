package com.archietheraccoon;

import java.util.Scanner;

public class CaesarVerschluesselung {
    public static void main(String[] Args) {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        if (userInput == 1) {
            System.out.println("VerschlüsselungsMethode");
        } else if (userInput == 2) {
            System.out.println("EntschlüsselungsMethode");
        } else {
            userInput = getUserInput();
        }
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        while (true) {
            try {
                userInput = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Wrong user input! Try again.");
                System.out.print("Input a number of the needed function: ");
                scanner.nextLine();
            }
        }
        return userInput;
    }
}
