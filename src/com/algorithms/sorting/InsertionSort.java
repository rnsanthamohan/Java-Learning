package com.algorithms.sorting;

public class InsertionSort {

    /**
     * In this implementation, the insertionSort function takes an array of integers as input and
     * sorts it in ascending order. It iterates through the array, starting from the second element
     * (index 1), and for each element, it compares it to the previous elements (in the sorted
     * portion of the array) and shifts elements to the right until it finds the correct
     * position for the current element.
     *
     * The main function demonstrates how to use the insertionSort method to sort an array
     * and then prints the sorted array.
     *
     * Keep in mind that Insertion Sort is not the most efficient sorting algorithm for large
     * datasets, but it is relatively easy to understand and implement. For larger datasets, more
     * advanced sorting algorithms like Quick Sort or Merge Sort are generally preferred.
     * @param arr int[]
     * @return sorted array
     */
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
