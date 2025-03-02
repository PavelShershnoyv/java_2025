package Laba1;

import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input name of the month: ");
        String nameMonth = in.nextLine();
        System.out.println("Input number of days in this month: ");
        String countDays = in.nextLine();

        System.out.println("The month " + nameMonth + " contains " + countDays + " days");
    }
}
