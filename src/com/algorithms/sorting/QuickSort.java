package com.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot-1);
            quickSort(array, pivot+1, end);
        }
        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = end;
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (array[j] <= array[pivot]) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        return i;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int array[] = {10, 3, 2, 7, 7, 5, 8, 4, 1, 2, 9, 7, 8, 11};

        System.out.println("User entered Array: ");
        QuickSort.printArray(array);

        QuickSort.quickSort(array, 0, array.length-1);

        System.out.println("\n\nAfter sorting: ");
        QuickSort.printArray(array);
    }
}
