package com.misc;

import java.util.Arrays;

public class KthSmallest {

    public static int[] bubbleSort(int[] arr) {
        if (arr != null) {
            int len = arr.length;
            for (int i = 0; i < len - 1; i++) {
                for (int j = 1; j < len - i - 1; j++) {
                    if (arr[j] < arr[j-1]) {
                        int temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        return arr;
    }

    public static final int findKthSmallestNumber(int[] arr, int k) {
        int result = -1;
        if (arr != null) {
            arr = bubbleSort(arr);
            result = arr[k-1];
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int result = KthSmallest.findKthSmallestNumber(arr, 1);
        System.out.println(result);
    }
}
