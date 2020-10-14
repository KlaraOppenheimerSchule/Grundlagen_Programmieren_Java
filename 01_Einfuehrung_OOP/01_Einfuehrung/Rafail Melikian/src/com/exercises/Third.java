package com.exercises;

import java.util.Scanner;

public class Third {
    String classNumber = "";
    public void main(String[] Args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First number:");
        int first = scanner.nextInt();
        System.out.print("Second number:");
        int second = scanner.nextByte();
        System.out.print("Third number:");
        int third = scanner.nextByte();
        System.out.print("Fourth number:");
        int fourth = scanner.nextByte();

        if (first != 0) {
            if (second != 0) {
                if (third == 0) {
                    if (fourth == 0) {
                        classNumber = "Klasse D";
                    } else {
                        classNumber = "Klasse E";
                    }
                } else {
                    classNumber = "Klasse C";
                }
            } else {
                classNumber = "Klasse B";
            }
        } else {
            classNumber = "Klasse A";
        }

        System.out.println(classNumber);
    }

}
