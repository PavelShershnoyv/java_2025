package Laba4;

import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите через пробел элементы массива типа byte:");
            String input = in.nextLine().trim();

            if (input.isEmpty()) {
                throw new IllegalArgumentException("Введена пустая строка");
            }

            int sum = 0;
            String[] arr = input.split(" ");
            byte[] numbers = new byte[arr.length];

            for (int i = 0; i < arr.length; i++) {
                numbers[i] = Byte.parseByte(arr[i]);
                sum += numbers[i];
            }

            System.out.println("Сумма элементов массива: " + sum);
        } catch (NumberFormatException e) {
            if (e.getMessage().contains("range")) {
                System.out.println("Ошибка: ввод или вычисление значения за границами диапазона типа");
            } else {
                System.out.println("Ошибка: ввод строки вместо числа");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
