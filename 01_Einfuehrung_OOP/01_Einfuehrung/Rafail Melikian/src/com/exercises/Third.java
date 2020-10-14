package com.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Third {
    public static void main(String[] Args) {
        String classNumber = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("IP Adress: ");
        String ipAdress = scanner.nextLine();
        String[] arrayOfIpAdress = ipAdress.split("\\.");
        System.out.println(Arrays.toString(arrayOfIpAdress));
        int firstNumbersOfIP = Integer.parseInt(arrayOfIpAdress[0]);
        System.out.println(firstNumbersOfIP);

        int[] binaryArray = new int[4];
        if ((firstNumbersOfIP / 128) == firstNumbersOfIP % 128) {
            firstNumbersOfIP = firstNumbersOfIP - 128;
            binaryArray[0] = 1;
        } else {
            binaryArray[0] = 0;
        }

        if ((firstNumbersOfIP / 64) == firstNumbersOfIP % 64) {
            firstNumbersOfIP = firstNumbersOfIP - 64;
            binaryArray[1] = 1;
        } else {
            binaryArray[1] = 0;
        }

        if ((firstNumbersOfIP / 32) == firstNumbersOfIP % 32) {
            firstNumbersOfIP = firstNumbersOfIP - 32;
            binaryArray[2] = 1;
        } else {
            binaryArray[2] = 0;
        }

        if ((firstNumbersOfIP / 16) == firstNumbersOfIP % 16) {
            firstNumbersOfIP = firstNumbersOfIP - 16;
            binaryArray[3] = 1;
        } else {
            binaryArray[3] = 0;
        }

        if (binaryArray[0] == 0) {
            classNumber = "Klasse A";
        } else {
            classNumber = "Bitch";
        }
    }

}
