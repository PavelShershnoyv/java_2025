package Timus.timus_1820;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        if (k >= n) {
            System.out.println(2);
            return;
        }

        int totalSides = 2 * n;
        int minutes = (totalSides + k - 1) / k;

        System.out.println(minutes);
    }
}
