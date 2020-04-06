package com.rd;

import java.util.ArrayList;

public class HSortInplace {

    public ArrayList<Double> array = new ArrayList<Double>();
    public Double list[];

    public void insert(double a) {
        this.array.add(a);
        Double b[] = array.toArray(list);
        sort(b);
    }

    public static void sort(Double array[]) {
        int noOfNodes = 1;
        double temp;

        for (int i = 2; i < array.length; i++) {
            noOfNodes++;
            fixHeapUp(array, noOfNodes);
        }

        for (int i = 1; i < array.length; i++) {
            // Deleting the root node of heap and saving it
            temp = array[1];
            // Replacing root node with last node of heap.
            array[1] = array[noOfNodes];
            // Putting the deleted root note to end of array
            array[noOfNodes] = temp;

            // Removed the top of heap so reducing no of nodes.
            noOfNodes--;
            fixHeapDown(array, 1, noOfNodes);
        }
        // Putting array in right order again.
        for (int i = 1, j = array.length - 1; i < j; i++, j--) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void fixHeapUp(Double array[], int index) {
        int parent;
        double temp;

        while (index != 1) {
            parent = index / 2;
            if (array[index] < array[parent]) {
                // Swap the parent with children which is larger than parent
                temp = array[parent];
                array[parent] = array[index];
                array[index] = temp;
                // Done with fixing at this level, lets fix one level up now.
                index = parent;
            } else {
                // Currently the heap is already fixed.
                break;
            }
        }
    }

    public static void fixHeapDown(Double array[], int index, int noOfNodes) {
        int c1, c2;
        double temp;

        while (2 * index <= noOfNodes) {
            c1 = 2 * index;
            c2 = 2 * index + 1;

            if (c2 <= noOfNodes) {
                if (array[index] < array[c1] && array[index] < array[c2]) {
                    break;
                } else {
                    if (array[c1] < array[c2]) {
                        temp = array[index];
                        array[index] = array[c1];
                        array[c1] = temp;

                        index = c1;
                    } else {
                        temp = array[index];
                        array[index] = array[c2];
                        array[c2] = temp;

                        index = c2;
                    }
                }

            } else {
                if (array[index] < array[c1]) {
                    break;
                } else {
                    temp = array[index];
                    array[index] = array[c1];
                    array[c1] = temp;

                    index = c1;
                }
            }
        }

    }
}