package com.rd;

import java.util.Random;
import java.util.stream.Stream;


public class TestRun {

    public static boolean arraySortedOrNot(Double arr[], int n) {
        // Array has one or no element
        if (n == 0 || n == 1)
            return true;

        for (int i = 1; i < n; i++)
            // Unsorted pair found
            if (arr[i - 1] > arr[i])
                return false;

        // No unsorted pair found
        return true;
    }

    public static Double[] createRandomArray(int size) {
        Double array[] = new Double[size];

        return array;
    }

    public static void main(String[] args) {
        int n = 10;
        while (n <= 10000000) {
            // Double[] x = { 9.2, 4.2, 1.1, 6.4, 3.5, 8.9, 2.5, 7.5 };
            Double[] x = Stream.generate(new Random()::nextDouble).distinct().limit(n).toArray(Double[]::new);
            for (int i = 0; i < n; i++) {
                x[i] *= 10000;
            }

            // Double[] x = new Random().doubles(n, 0, Double.MAX_VALUE);
            // new Random().ints(n, 0, 10).
            // System.out.println(Arrays.toString(x));
            HeapPQSort pqSort = new HeapPQSort(n);
            // PQLinkedList pq = new PQLinkedList();

            long startTime = System.nanoTime();
            for (Double item : x) {
                // pq.insert(item, item);
                pqSort.insert(item);
            }

            for (int k = 0; k < x.length; k++) {
                // x[k] = pq.getMin();
                x[k] = pqSort.getMin();
            }

            long endTime = System.nanoTime();
            long durationInNano = (endTime - startTime); // Total execution time in nano seconds
            System.out.println(n + " " + durationInNano + " " + arraySortedOrNot(x, n));
            n = (int) (n * 1.1);
        }
    }
}
