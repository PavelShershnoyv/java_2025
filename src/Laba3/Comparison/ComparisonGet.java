package Laba3.Comparison;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class ComparisonGet {

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        int size = 3000000;

        for (int i = 0; i < size; i++) {
            arrayDeque.add(i);
            linkedHashSet.add(i);
            arrayList.add(i);
        }

        long start = System.nanoTime();
        int middleIndexArrayDeque = size / 2;
        Iterator<Integer> arrayDequeIterator = arrayDeque.iterator();
        for (int i = 0; i < middleIndexArrayDeque; i++) {
            arrayDequeIterator.next();
        }
        Integer middleElementArrayDeque = arrayDequeIterator.next();
        long end = System.nanoTime();
        long result = end - start;
        System.out.println("Время получения элемента для ArrayDeque: " + result);

        start = System.nanoTime();
        int middleIndexLinkedHashSet = size / 2;
        Iterator<Integer> linkedHashSetIterator = linkedHashSet.iterator();
        for (int i = 0; i < middleIndexLinkedHashSet; i++) {
            linkedHashSetIterator.next();
        }
        Integer middleElementLinkedHashSet = linkedHashSetIterator.next();
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время получения элемента для LinkedHashSet: " + result);

        start = System.nanoTime();
        int middleIndexArrayList = size / 2;
        Integer middleElementArrayList = arrayList.get(middleIndexArrayList);
        end = System.nanoTime();
        result = end - start;
        System.out.println("Время получения элемента для ArrayList: " + result);
    }
}
