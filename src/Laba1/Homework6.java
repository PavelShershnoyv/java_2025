package Laba1;

import java.util.Scanner;

public class Homework6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input your name and year of birth separated by spaces: ");
        String lineText = in.nextLine();
        String[] arguments = lineText.split(" ");
        int age = 2025 - Integer.parseInt(arguments[1]);

        System.out.println("Your name: " + arguments[0] + " age: " + age);
    }
}
