package Laba1;

import java.util.Scanner;

public class Homework9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input number: ");
        int number = in.nextInt();
        int lastNumber = number - 1;
        int nextNumber = number + 1;
        int sum = lastNumber + number + nextNumber;
        int square = sum * sum;

        System.out.println(lastNumber + " " + number + " " + nextNumber + " " + square);
    }
}
