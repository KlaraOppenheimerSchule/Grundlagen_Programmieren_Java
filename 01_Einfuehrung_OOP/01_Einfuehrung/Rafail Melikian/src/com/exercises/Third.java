package com.exercises;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Third {
    public static void main(String[] Args) {
        String classNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.print("IP Adress: ");
        String ipAdress = scanner.nextLine();
        String[] arrayOfIpAdress = ipAdress.split("\\.");
        int firstNumbersOfIP = Integer.parseInt(arrayOfIpAdress[0]);
        int secondNumbersOfIP = Integer.parseInt(arrayOfIpAdress[1]);
        int thirdNumbersOfIP = Integer.parseInt(arrayOfIpAdress[2]);
        int fourthNumbersOfIP = Integer.parseInt(arrayOfIpAdress[3]);

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

        boolean isGueltig = true;
        boolean isReserved = false;
        String reasonOfReserved = "NICHT RESERVIERT.";

        if (binaryArray[0] == 0) {
            classNumber = "A";
            isGueltig = (secondNumbersOfIP <= 255 && thirdNumbersOfIP <= 255 && fourthNumbersOfIP <= 255);
            if (secondNumbersOfIP == 255 && thirdNumbersOfIP == 255 && fourthNumbersOfIP == 255) {
                isReserved = true;
                isGueltig = false;
                reasonOfReserved = "Broad-cast.";
            } else if (secondNumbersOfIP == 0 && thirdNumbersOfIP == 0 && fourthNumbersOfIP == 0) {
                isGueltig = false;
                isReserved = true;
                reasonOfReserved = "Netz-ID";
            }
        }
        else if (binaryArray[0] == 1 && binaryArray[1] == 0) {
            classNumber = "B";
            isGueltig = (thirdNumbersOfIP <= 255 && fourthNumbersOfIP <= 255);
            if (thirdNumbersOfIP == 255 && fourthNumbersOfIP == 255) {
                isReserved = true;
                isGueltig = false;
                reasonOfReserved = "Broad-cast.";
            } else if (thirdNumbersOfIP == 0 && fourthNumbersOfIP == 0) {
                isGueltig = false;
                isReserved = true;
                reasonOfReserved = "Netz-ID";
            }
        }
        else if (binaryArray[0] == 1 && binaryArray[1] == 1 && binaryArray[2] == 0) {
            classNumber = "C";
            isGueltig = (fourthNumbersOfIP <= 255);
            if (fourthNumbersOfIP == 255) {
                isReserved = true;
                isGueltig = false;
                reasonOfReserved = "Broad-cast.";
            } else if (fourthNumbersOfIP == 0) {
                isGueltig = false;
                isReserved = true;
                reasonOfReserved = "Netz-ID";
            }
        }
        else if (binaryArray[0] == 1 && binaryArray[1] == 1 && binaryArray[2] == 1 && binaryArray[3] == 0) {
            classNumber = "D";
        }
        else {
            classNumber = "E";
        }

        System.out.println("Die IP-Adresse gehört zu Klasse: " + classNumber + ". Ist gültig: " + isGueltig +
                ". Ist reserviert: " + isReserved + ". Wenn resertiert, warum: " + reasonOfReserved);
    }

}
