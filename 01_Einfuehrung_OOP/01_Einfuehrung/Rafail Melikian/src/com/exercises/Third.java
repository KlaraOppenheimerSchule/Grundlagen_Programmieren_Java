package com.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

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
        int[] bytesForBinary = IntStream.of(128, 64, 32, 16).toArray();

        for (int i = 0; i < bytesForBinary.length; i++) {
            if (firstNumbersOfIP - bytesForBinary[i] >= 0) {
                firstNumbersOfIP = firstNumbersOfIP - bytesForBinary[i];
                binaryArray[i] = 1;
            } else {
                binaryArray[i] = 0;
            }
        }
        System.out.println(Arrays.toString(binaryArray));

        boolean isGueltig = true;

        if (binaryArray[0] == 0) {
            classNumber = "A";
        }
        else if (binaryArray[0] == 1 && binaryArray[1] == 0) {
            classNumber = "B";
        }
        else if (binaryArray[0] == 1 && binaryArray[1] == 1 && binaryArray[2] == 0) {
            classNumber = "C";
        }
        else if (binaryArray[0] == 1 && binaryArray[1] == 1 && binaryArray[2] == 1 && binaryArray[3] == 0) {
            classNumber = "D";
        }
        else {
            classNumber = "E";
        }

        System.out.println(classNumber);
    }

}
