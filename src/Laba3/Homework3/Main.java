package Laba3.Homework3;

import java.util.Scanner;

public class Main {

    public static void inputArray(int[] arr, int i, Scanner in) {
        if (i >= arr.length) {
            return;
        }
        System.out.println("Введите элемент " + i + ": ");
        arr[i] = in.nextInt();
        inputArray(arr, i + 1, in);
    }

    public static void outputArray(int[] arr, int i) {
        if (i >= arr.length) {
            return;
        }
        System.out.println("Элемент " + i + ": " + arr[i]);
        outputArray(arr, i + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива: ");

        int n = in.nextInt();
        int[] arr = new int[n];
        inputArray(arr, 0, in);

        outputArray(arr, 0);
    }
}
