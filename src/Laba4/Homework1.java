package Laba4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите через пробел элементы массива: ");
            String input = in.nextLine().trim();

            if (input.isEmpty()) {
                throw new IllegalArgumentException("Введена пустая строка");
            }

            String[] arr = input.split(" ");
            int[] numbers = new int[arr.length];
            int countNegativeNumbers = 0;
            int countPositiveNumbers = 0;
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                numbers[i] = Integer.parseInt(arr[i]);
                if (numbers[i] == 0) {
                    continue;
                }
                if (numbers[i] < 0) {
                    countNegativeNumbers++;
                } else {
                    countPositiveNumbers++;
                    sum += numbers[i];
                }
            }
            if (countNegativeNumbers == numbers.length) {
                throw new RuntimeException("Отсутствуют положительные элементы в массиве");
            }
            if (countPositiveNumbers != 0) {
                System.out.println((double) sum / countPositiveNumbers);
            } else {
                System.out.println(sum);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка входных данных");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
