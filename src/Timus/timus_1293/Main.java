package Timus.timus_1293;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        int s = a * b;

        int result = s * 2 * n;
        System.out.println(result);
    }
}
