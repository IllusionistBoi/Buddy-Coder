package com.rd;


class HeapPQSort {

    Double array[];
    int size;
    int count;

    HeapPQSort(int size) {
        this.size = size;
        array = new Double[size];
        count = 0;
    }

    public void insert(Double value) {
        if (count == size) {
            return;
        }
        array[count++] = value;
        heapifyUp(count);
    }

    private void heapifyUp(int index) {
        // Base condition
        if (index <= 0) {
            return;
        }
        int parent = (index - 1) / 2;
        Double temp;
        if (array[index - 1] < array[parent]) {
            // As parent is greater than the child, so we swap it.
            temp = array[parent];
            array[parent] = array[index - 1];
            array[index - 1] = temp;

            // Doing heapifyUp for upper level now.
            heapifyUp(parent + 1);
        }

    }

    public Double getMin() {
        Double rightValue = array[0];
        array[0] = Double.MAX_VALUE;
        heapifyDown(0);
        return rightValue;
    }

    private void heapifyDown(int index) {
        // Base condition
        if (index >= array.length) {
            return;
        }
        Double temp;
        int minIndex = index;
        int left = 2 * index;
        int right = (2 * index) + 1;

        // Checking which child is samller than the parent index.
        if (left < array.length && array[index] > array[left]) {
            minIndex = left;
        }

        if (right < array.length && array[minIndex] > array[right]) {
            minIndex = right;
        }

        // Swapping if not Equal
        if (minIndex != index) {
            temp = array[minIndex];
            array[minIndex] = array[index];
            array[index] = temp;

            // Doing heapifyDonw for lower level now.
            heapifyDown(minIndex);
        }

    }
}