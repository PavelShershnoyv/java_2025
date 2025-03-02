package Timus.timus_1209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] position = new int[n];
        int[] result = new int[n];
        ArrayList<Integer> listIndexes = new ArrayList<>();
        int limit = (int) Math.pow(2, 32) - 1;

        for (int i = 0; i < n; i++) {
            position[i] = in.nextInt();
        }

        int el = Arrays.stream(position).max().getAsInt();
        int index = 1;
        for (int i = 0; i < limit; i++) {
            index += i;
            listIndexes.add(index);
            if (el < index) {
               break;
            }
        }

        int start = 0;

        int[] copySortPosition = position.clone();
        Arrays.sort(copySortPosition);

        for (int element : copySortPosition) {
            for (int i = start; i < listIndexes.size(); i++) {
                if (element == listIndexes.get(i)) {
                    int j = Arrays.binarySearch(position, element);
                    result[j] = 1;
                    start = i;
                    break;
                }
                if (element < listIndexes.get(i)) {
                    start = i;
                    break;
                }
            }
        }


        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
