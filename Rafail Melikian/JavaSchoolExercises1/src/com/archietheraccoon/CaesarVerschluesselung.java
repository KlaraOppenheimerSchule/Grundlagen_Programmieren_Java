package com.archietheraccoon;

import java.util.Scanner;

public class CaesarVerschluesselung {
    public static void main(String[] Args) {
        System.out.println("#######CaesarVerschluesselung########");
        System.out.println("(1)Verschlüsseln / (2)Entschlüsseln");
        System.out.print("Input a number of the needed function:");

        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        try {
            userInput = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }
}
