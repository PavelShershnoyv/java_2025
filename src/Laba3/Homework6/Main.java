package Laba3.Homework6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static int getHumanWithArrayList(ArrayList<Integer> arrayList) {
        int index = 0;

        while (arrayList.size() > 1) {
            index = (index + 1) % arrayList.size();
            arrayList.remove(index);
            index = index % arrayList.size();
        }

        return arrayList.get(0);
    }

    public static int getHumanWithLinkedList(LinkedList<Integer> linkedList) {
        Iterator<Integer> iterator = linkedList.iterator();
        while (linkedList.size() > 1) {
            if (iterator.hasNext()) {
                iterator.next();
                if (!iterator.hasNext()) {
                    iterator = linkedList.iterator();
                }
                iterator.next();
                iterator.remove();
            } else {
                iterator = linkedList.iterator();
            }
        }

        return linkedList.get(0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("Введите количетсво человек: ");

        int n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        long startTime = System.nanoTime();
        System.out.println("Последний человек (ArrayList): " + getHumanWithArrayList(arrayList));
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        System.out.println("Время работы программы с ArrayList: " + time);

        startTime = System.nanoTime();
        System.out.println("Последний человек (LinkedList): " + getHumanWithLinkedList(linkedList));
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.println("Время работы программы с LinkedList: " + time);


    }
}
