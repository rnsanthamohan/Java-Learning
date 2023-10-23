package com.algorithms.sorting;

public class BinarySearch {
    /**
     * In this code, the binarySearch method uses a while loop to perform the
     * binary search iteratively. It maintains two pointers, left and right,
     * that define the range of the search. The loop continues until left is less
     * than or equal to right, and the target value is either found, or the search
     * range is exhausted. If the target is found, it returns the index of the
     * target in the array. If the target is not found, it returns -1.
     * @param array int array to be sorted
     * @param target value to be searched
     * @param left start index
     * @param right end
     * @return sorted array
     */
    public static int binarySearch(int[] array, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == array[mid]) {
                //if the target matches the mid value, then return the mid index
                return mid;
            } else if (array[mid] < target) {
                //if the target value is greater than mid, then search right of the array
                return binarySearch(array, target, mid+1, right);
            } else if (array[mid] > target) {
                //if the target value is lesser than mid, then search left of the array
                return binarySearch(array, target, left, mid-1);
            }
        }

        return -1; // Target not found
    }

    private static int binarySearchWithoutRecurssion(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                //if the target matches the mid value, then return the mid index
                return mid;
            } else if (array[mid] < target) {
                //if the target value is greater than mid, then search right of the array
                left = mid + 1;
            } else {
                //if the target value is lesser than mid, then search left of the array
                right = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 5, 7, 8, 8, 9, 10};
        int value = 3;
        int idx = BinarySearch.binarySearch(arr, value, 0, arr.length -1);
        System.out.println(idx);
        idx = BinarySearch.binarySearchWithoutRecurssion(arr, value);
        System.out.println(idx);
    }
}
