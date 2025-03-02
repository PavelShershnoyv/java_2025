package Laba1;

import java.util.Scanner;

public class Homework7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input yor age: ");
        int age = in.nextInt();
        int yearBirth = 2025 - age;

        System.out.println("Your year of birth: " + yearBirth);
    }
}
