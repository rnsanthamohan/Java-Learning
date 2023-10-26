package com.algorithms.sorting;

public class SelectionSort {

    public int[] selectionSort(int[] arr) {
        //check if the array in initialized
        if (arr != null) {
            int len = arr.length;
            //looping for sorted array
            for (int s = 0; s < len; s++) {
                //get the index of outer sorted array
                int minIndex = s;
                for (int u = s + 1; u < len; u++) {
                    //find which is the smallest element to right of 'minIndex'
                    if (arr[u] < arr[minIndex]) {
                        minIndex = u;
                    }
                } //end of inner loop
                // if s is not minimum index then swap
                if (minIndex != s) {
                    int temp = arr[s];
                    arr[s] = arr[minIndex];
                    arr[minIndex] = temp;
                }
            }//end of outer loop
        }
        return arr;
    }

    public static void main(String[] args) {
        //int[] arr = new int[] {30, 10, 50, 20, 60, 40, 5, 55, 15, 65, 2};
        int[] arr = new int[] {7, 5, 4, 2};
        SelectionSort selSort = new SelectionSort();
        int[] result = selSort.selectionSort(arr);
        for (int item : result) {
            System.out.print(item + " ");
        }
    }
}
