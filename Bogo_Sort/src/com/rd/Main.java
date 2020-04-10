package com.rd;

import java.util.Arrays;

class RandomSort {

    /**
     * Method to print number of times a sorting happens.
     * @param i
     */
    public RandomSort(int[] i) {
        int counter = 0;

        System.out.println("We'll sort " + i.length + " elements:");

        // Till the time element are not sorted.
        while(!isSorted(i)) {
            shuffle(i);
            counter++;
        }

        // when sorting done. we print the counter
        System.out.println("The Solution found! (shuffled " + counter + " these many number of times)");
        print(i);
    }

   
 /**
     * Method to check if array is Sorted or not
     * @param arr array passed
     * @return boolean value
     */
    private static boolean isSorted(int[] arr) {
       // Iterated through the array and checked if previous value is greater or not.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * Method to print the array
     * @param i
     */
    private void print(int[] i) {
        // This for method allow us to iterate through the array without using indices
        for(int x : i)
            System.out.print(x + ", ");

        // New Line printed after entire array printed
        System.out.println();
    }


    /**
     * Method to shuffle random indexes of given array
     * @param i array to be shuffled
     */
    private void shuffle(int[] i) {

        /* Takes two random index and assigns it to index 1 and 2 respectively. */
        for(int x = 0; x < i.length; ++x) {
            int index1 = (int) (Math.random() * i.length);
            int index2 = (int) (Math.random() * i.length);

            int a = i[index1];

            i[index1] = i[index2];
            i[index2] = a;
        }
    }


    public static void main(String[] args) {

    // Unsorted array is initialised and printed
        int[] i = {1, 5, 2, 8, 5, 2, 4, 2, 6, 7, 66};
         System.out.println("Unsorted: " + Arrays.toString(i));

         // To check the run time of the program
        final long startTime = System.currentTimeMillis();

        // Function Called with array passed as parameter
        new RandomSort(i);

        // Computation time printed
        final long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Computation Time is : " + elapsedTime);

    }
}

