package Laba2;

import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите размер первого массива: ");
        int n = in.nextInt();
        System.out.println("Укажите размер второго массива: ");
        int m = in.nextInt();

        int[][] arr = new int[n][m];
        int el = 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = el;
                    el += 1;
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    arr[i][j] = el;
                    el += 1;
                }
            }
        }

        System.out.println("Заполненный массив: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
