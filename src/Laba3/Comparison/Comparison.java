package Laba3.Comparison;

import java.util.*;

public class Comparison {
    private static long getRunningTime(List<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }

        long end = System.currentTimeMillis();

        return end - start;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        long start = System.nanoTime();
        arrayDeque.addFirst(1);
        long end = System.nanoTime();
        long result = end - start;
        System.out.println("Время выполнения операции добавления в начало для ArrayDeque: " + result);

        start = System.nanoTime();
        linkedHashSet.add(1);
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции добавления в начало для LinkedHashSet: " + result);

        start = System.nanoTime();
        arrayList.add(0, 1);
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции добавления в начало для ArrayList: " + result);


        arrayDeque.add(2);
        arrayDeque.add(3);
        start = System.nanoTime();
        int middleIndexArrayDeque = arrayDeque.size() / 2;
        ArrayDeque<Integer> tempDeque = new ArrayDeque<>();
        for (int i = 0; i <= middleIndexArrayDeque; i++) {
            tempDeque.add(arrayDeque.pollFirst());
        }
        tempDeque.add(4);
        while (!arrayDeque.isEmpty()) {
            tempDeque.add(arrayDeque.pollFirst());
        }
        arrayDeque = tempDeque;
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции добавления в середину для ArrayDeque: " + result);

        linkedHashSet.add(2);
        linkedHashSet.add(3);
        start = System.nanoTime();
        linkedHashSet.add(4);
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции добавления в середину для LinkedHashSet: " + result);

        arrayList.add(2);
        arrayList.add(3);
        start = System.nanoTime();
        int middleIndexArrayList = arrayList.size() / 2;
        arrayList.add(middleIndexArrayList, 4);
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции добавления в середину для ArrayList: " + result);

        start = System.nanoTime();
        arrayDeque.addLast(5);
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции добавления в конец для ArrayDeque: " + result);

        start = System.nanoTime();
        linkedHashSet.add(5);
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции добавления в конец для LinkedHashSet: " + result);

        start = System.nanoTime();
        arrayList.add(5);
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции добавления в середину для ArrayList: " + result);


        // Удаление


        start = System.nanoTime();
        arrayDeque.pollFirst();
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции удаления в начале для ArrayDeque: " + result);

        start = System.nanoTime();
        Iterator<Integer> iterator = linkedHashSet.iterator();
        if (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции удаления в начале для LinkedHashSet: " + result);

        start = System.nanoTime();
        arrayList.remove(0);
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции удаления в начале для ArrayList: " + result);

        start = System.nanoTime();
        middleIndexArrayDeque = arrayDeque.size() / 2;
        tempDeque = new ArrayDeque<>();
        for (int i = 0; i < middleIndexArrayDeque; i++) {
            tempDeque.add(arrayDeque.pollFirst());
        }
        arrayDeque.pollFirst();
        while (!arrayDeque.isEmpty()) {
            tempDeque.add(arrayDeque.pollFirst());
        }
        arrayDeque = tempDeque;
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции удаления в середине для ArrayDeque: " + result);

        start = System.nanoTime();
        iterator = linkedHashSet.iterator();
        int middleIndexLinkedHashSet = linkedHashSet.size() / 2;
        for (int i = 0; i <= middleIndexLinkedHashSet; i++) {
            iterator.next();
        }
        iterator.remove();
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции удаления в середине для LinkedHashSet: " + result);

        start = System.nanoTime();
        middleIndexArrayList = arrayList.size() / 2;
        arrayList.remove(middleIndexArrayList);
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции удаления в середине для ArrayList: " + result);

        start = System.nanoTime();
        arrayDeque.pollLast();
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции удаления в конце для ArrayDeque: " + result);

        start = System.nanoTime();
        iterator = linkedHashSet.iterator();
        Integer lastElement = null;
        while (iterator.hasNext()) {
            lastElement = iterator.next();
        }
        linkedHashSet.remove(lastElement);
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции удаления в конце для LinkedHashSet: " + result);

        start = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время выполнения операции удаления в конце для ArrayList: " + result);
    }
}
