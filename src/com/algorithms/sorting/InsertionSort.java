package com.algorithms.sorting;

public class InsertionSort {

    public int[] insertionSort(int[] arr) {
        if (arr != null) {
            int len = arr.length;
            //loop from second element
            for (int i = 1; i < len; i++) {
                int temp = arr[i];
                int j = i;
                //loop the sorted array in reverse
                while (j > 0 && arr[j-1] > temp) {
                    arr[j] = arr[j-1];
                    j--;
                }
                arr[j] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {30, 10, 50, 20, 60, 40, 5, 55, 15, 65, 2};
        InsertionSort iSort = new InsertionSort();
        int[] result = iSort.insertionSort(arr);
        for (int item : result) {
            System.out.print(item + " ");
        }
    }
}
