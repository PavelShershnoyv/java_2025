package Laba2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = id.nextInt();
        System.out.println("Размер массива равен " + size);
        int[] nums = new int[size];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt(200);

            System.out.println("Элемент массива ["+i+"] = " + nums[i]);
        }

        int minElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minElement) {
                minElement = nums[i];
            }
        }

        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == minElement) {
                indexes.add(i);
            }
        }

        String indexesString = indexes.toString();

        System.out.println("Минимальный элемент массива: " + minElement);
        System.out.println("Встречается под индексом(ами): " + indexesString.substring(1, indexesString.length() - 1));
    }
}
