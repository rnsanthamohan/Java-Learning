package com.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.*;

public class KthElementList {

    public static int findKthElement(int[] arr, int k) {
        int result = -1;
        if (arr != null && k > 1 && k < arr.length -1) {
            Arrays.sort(arr);
            result = arr[k-1];
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int result = KthElementList.findKthElement(arr, 3);
        System.out.println(result);
    }
}
