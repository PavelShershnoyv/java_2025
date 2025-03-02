package Laba1;

import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input surName: ");
        String surName = in.nextLine();
        System.out.println("Input name: ");
        String name = in.nextLine();
        System.out.println("Input otchestvo: ");
        String otchestvo = in.nextLine();

        System.out.println("Hello " + surName + ", " + name + ", " + otchestvo);
    }
}
