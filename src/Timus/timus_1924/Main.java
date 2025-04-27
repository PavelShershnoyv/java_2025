package Timus.timus_1924;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int remainder = n % 4;
        String ans = (remainder == 0 || remainder == 3) ? "black" : "grimy";

        System.out.println(ans);
        in.close();
    }
}
