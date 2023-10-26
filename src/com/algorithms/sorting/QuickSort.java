package com.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot-1);
            quickSort(array, pivot+1, right);
        }
        return array;
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = right;
        int i = left - 1;
        for (int j = left; j <= right; j++) {
            if (array[j] <= array[pivot]) {
                i++;
                //swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        return i;
    }

    public static void printArray(int[] array) {
        for (int n : array) {
            System.out.print(n + " ");
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
