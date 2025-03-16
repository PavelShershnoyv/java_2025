package Laba2;

import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите текст для шифрования: ");
        String text = in.nextLine();
        System.out.println("Введите ключ: ");
        int key = in.nextInt();
        String encryptedText = Encrypt.getEncryptString(text, key);
        System.out.println("Текст после преобразования: " + encryptedText);
        System.out.println("Выполнить обратное преобразование? (y/n)");
        boolean flag = true;

        while (flag) {
            String ans = in.next();
            if (ans.equals("y")) {
                flag = false;
                System.out.println("Выполнено обратное преобразование: " + text);
            } else if (ans.equals("n")) {
                flag = false;
                System.out.println("До свидания!");
            } else {
                System.out.println("Введите корректный ответ (y/n)");
            }
        }


    }
}
