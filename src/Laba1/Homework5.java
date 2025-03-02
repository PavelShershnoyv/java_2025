package Laba1;

import java.util.Scanner;

public class Homework5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input your year of birth: ");
        int yearBirth = in.nextInt();
        int age = 2025 - yearBirth;

        System.out.println("Your age is " + age);
    }
}
