package Laba6;

import java.util.Arrays;
import java.util.Random;

public class Homework6 {
    public static void main(String[] args) {
        int[] array = generateRandomArray(100);

        int maxMultiThread = findMaxMultiThread(array);
        System.out.println("Сумма элементов в массиве: " + maxMultiThread);
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    private static int findMaxMultiThread(int[] array) {
        int numThreads = 4;

        final int[] threadResults = new int[numThreads];
        Arrays.fill(threadResults, 0);

        Thread[] threads = new Thread[numThreads];
        int chunkSize = array.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            final int startIndex = i * chunkSize;
            final int endIndex = (i == numThreads - 1) ? array.length : (i + 1) * chunkSize;

            threads[i] = new Thread(() -> {
                int sum = 0;
                for (int j = startIndex; j < endIndex; j++) {
                    sum += array[j];
                }
                threadResults[threadIndex] = sum;
            });

            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int overallSum = 0;
        for (int result : threadResults) {
            overallSum += result;
        }

        return overallSum;
    }
}
