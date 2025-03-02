package Laba1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input current day of the week: ");
        String day = in.nextLine();
        System.out.println("Input name of the month: ");
        String month = in.nextLine();
        System.out.println("Input day of the month: ");
        String numberMonth = in.nextLine();

        System.out.println("Today's date: " + day + " " + numberMonth + " " + month);
    }
}
