package Laba3.Homework5;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(11, "eleven");

        StringBuilder stringMoreFive = new StringBuilder();
        StringBuilder stringKeyZero = new StringBuilder();
        int mul = 1;

        for (Map.Entry<Integer, String> el : map.entrySet()){
            if (el.getKey() > 5) {
                stringMoreFive.append(el.getValue() + " ");
            }
            if (el.getKey() == 0) {
                stringKeyZero.append(el.getValue() + ", ");
            }
            if (el.getValue().length() > 5) {
                mul *= el.getKey();
            }
        }

        if (stringMoreFive.length() > 0) {
            stringMoreFive.setLength(stringMoreFive.length() - 1);
        }

        if (stringKeyZero.length() > 0) {
            stringKeyZero.setLength(stringKeyZero.length() - 2);
        }

        System.out.println("Строки, у которых ключ > 5: " + stringMoreFive);
        System.out.println("Строки, у которых ключ = 0: " + stringKeyZero);
        System.out.println("Произведение ключей, у которых строка > 5: " + mul);
    }
}
