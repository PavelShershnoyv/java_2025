package Timus.timus_1139;

import java.util.Scanner;

public class Main {
    private static int nod(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt() - 1;
        int m = in.nextInt() - 1;

        System.out.println(n + m - nod(n, m));
    }
}
