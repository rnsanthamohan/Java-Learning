package com.algorithms.sorting;

public class BubbleSort {

    public int[] sort(int[] arr) {
        if (arr != null) {
            int n = arr.length;
            //run from the first cell to the last cell
            for (int i = 0; i < n - 1; i++) { //O(n)
                //run from first till last but the previous iteration
                for (int j = 0; j < n - i - 1; j++) { //O(n)
                    if (arr[j] > arr[j+1]) {
                        //swap if the first is greater than the second
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {30, 10, 50, 20, 60, 40, 5, 55, 15, 65, 2};
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(arr);
        for (int item : result) {
            System.out.print(item + " ");
        }
    }
}
