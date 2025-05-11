package Timus.timus_1120;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long s = scanner.nextLong();
        int a = 0;
        int n = 0;

        for (int length = (int)Math.sqrt(2 * s); length >= 1; length--) {
            long numerator = s - (long)length * (length - 1) / 2;
            if (numerator % length == 0 && numerator / length > 0) {
                a = (int)(numerator / length);
                n = length;
                break;
            }
        }

        System.out.println(a + " " + n);
        scanner.close();
    }
}
