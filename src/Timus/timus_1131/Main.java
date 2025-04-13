package Timus.timus_1131;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int hours = 0;
        int computer = 1;

        while (computer < n && computer <= k) {
            computer *= 2;
            hours++;
        }

        if (computer < n) {
            int remain = n - computer;
            hours += (remain + k - 1) / k;
        }

        System.out.println(hours);
    }
}
