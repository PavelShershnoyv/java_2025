package Timus.timus_1131;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int hours = 0;
        int computer = 1;

        while (n > 0) {
            n -= computer;
            computer += computer;
            hours += 1;
            if (computer > k) {
                computer = k;
            }
        }

        System.out.println(hours);
    }
}
