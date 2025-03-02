package Timus.timus_1264;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int result = (m + 1) * n;

        System.out.println(result);
    }
}
