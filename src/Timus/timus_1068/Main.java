package Timus.timus_1068;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = 0;

        if (n > 0) {
            for (int i = 1; i <= n; i++){
                result += i;
            }
        } else {
            for (int i = 1; i >= n; i--) {
                result += i;
            }
        }

        System.out.println(result);
    }
}
