package com.exercises;

import java.util.Scanner;

public class First {
    private String firstNameOfUser, secondNameOfUser;

    public void addUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vorname: ");
        setFirstName(scanner.nextLine());
        System.out.print("Nachname: ");
        setSecondName(scanner.nextLine());
    }

    public void setFirstName(String firstNameOfUser) {
        this.firstNameOfUser = firstNameOfUser;
    }

    public void setSecondName(String secondNameOfUser) {
        this.secondNameOfUser = secondNameOfUser;
    }
    public String getFirstNameOfUser() {
        return this.firstNameOfUser;
    }
    public String getSecondNameOfUser() {
        return this.secondNameOfUser;
    }

    public static void main(String[] Args) {
        First mitarbeiter1 = new First();
        mitarbeiter1.addUser();

        System.out.println("First name: " + mitarbeiter1.getFirstNameOfUser() +
                ", Second name: " + mitarbeiter1.getSecondNameOfUser());

    }
}
