package Timus.timus_1209;

import java.util.Arrays;
import java.util.Scanner;

// Не проходит по времени(

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] position = new int[n];
        int[] result = new int[n];
        int limit = (int) Math.pow(2, 32) - 1;

        for (int i = 0; i < n; i++) {
            position[i] = in.nextInt();
        }
        Arrays.sort(position);

        for (int i = 0; i < position.length; i++) {
            int el = position[i];
            int index = 1;
            for (int j = 0; j < limit; j++) {
                index += j;
                if (el == index) {
                    result[i] = 1;
                    break;
                } else if (el < index) {
                    result[i] = 0;
                    break;
                }
            }
        }

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
