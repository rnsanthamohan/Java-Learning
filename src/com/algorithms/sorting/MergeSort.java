package com.algorithms.sorting;

public class MergeSort {

    public int[] mergeSort(int[] arr, int left, int right) {
        if (right > left) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
        return arr;
    }

    private void merge(int[] arr, int left, int middle, int right) {
        int[] leftTmpArray = new int[middle - left + 2];  //Create tmp arrays
        int[] rightTmpArray = new int[right - middle + 1];

        for (int i = 0; i <= middle - left; i++) //Copy values from Array 'A' to these tmp arrays
            leftTmpArray[i] = arr[left + i];
        for (int i = 0; i < right - middle; i++)
            rightTmpArray[i] = arr[middle + 1 + i];

        leftTmpArray[middle - left + 1] = Integer.MAX_VALUE; //Merge values and insert into Array 'A'
        rightTmpArray[right - middle] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if (leftTmpArray[i] < rightTmpArray[j]) {
                arr[k] = leftTmpArray[i];
                i++;
            } else {
                arr[k] = rightTmpArray[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int array[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
        MergeSort mergeSort = new MergeSort();
        System.out.println("User entered Array: ");
        mergeSort.printArray(array);

        long start = System.nanoTime();
        mergeSort.mergeSort(array, 0, array.length-1);
        long end = System.nanoTime();
        System.out.println("\n\nTime to execute this algo: " + (end-start));

        System.out.println("\nAfter sorting: ");
        mergeSort.printArray(array);
    }

    private static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
    }
}
