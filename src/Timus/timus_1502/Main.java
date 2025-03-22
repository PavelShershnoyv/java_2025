package Timus.timus_1502;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long result = 0;

        for (int i = 0; i <= n; i++){
            for (int j = i; j <= n; j++){
                result += i;
                result += j;
            }
        }

        System.out.println(result);
    }
}
