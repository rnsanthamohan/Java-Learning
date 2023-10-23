package com.algorithms.sorting;

public class SortingHelper {

    private static final SortingHelper instance = new SortingHelper();

    private SortingHelper() {

    }

    public static SortingHelper getInstance() {
        return instance;
    }

    public int[] sort(SortType type, int[] arr) {
        int[] result = null;
        switch (type) {
            case BubbleSort:
                result = bubbleSort(arr);
                break;
            case SelectionSort:
                result = selectionSort(arr);
                break;
            case InsertionSort:
                result = insertionSort(arr);
                break;
            case MergeSort:
                result = mergeSort(arr, 0, arr.length-1);
                break;
        }
        return result;
    }

    private int[] selectionSort(int[] array) {
        int len = array.length;
        int minIndex = 0;
        //looping for sorted array
        for (int sortedIdx = 0; sortedIdx < len-1; sortedIdx++) {
            //get the index of outer sorted array
            minIndex = sortedIdx;
            for (int unsortedIdx = sortedIdx + 1; unsortedIdx < len-1;unsortedIdx++) {
                //find which is the smallest element to right of 'minIndex'
                if (array[unsortedIdx] < array[minIndex]) {
                    minIndex = unsortedIdx;
                }
            }//end of inner loop
            if (minIndex != sortedIdx) {
                // if s is not minimum index then swap
                int tmp = array[sortedIdx];
                array[sortedIdx] = array[minIndex];
                array[minIndex] = tmp;
            }
        }//end of outer loop
        return array;
    }

    private int[] bubbleSort(int[] array) {
        int len = array.length;

        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

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

    private int[] mergeSort(int[] a, int l, int r) {
        if (r > l) {
            int m = (l+r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m+1, r);
            merge(a, l, m, r);
        }
        return a;
    }

    private void merge(int[] a, int l, int m, int r) {
        int[] tmpLeftArray = new int[m-l+2];
        int[] tmpRightArray = new int[r-m+1];

        for(int i =0; i <= m-l; i++)
            tmpLeftArray[i] = a[l+i];
        for(int i =0; i < r-m; i++)
            tmpRightArray[i] = a[m+1+i];

        tmpLeftArray[m-l+1] = Integer.MAX_VALUE;
        tmpRightArray[r-m] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = l; k <= r; k++) {
            if (tmpLeftArray[i] < tmpRightArray[j]) {
                a[k] = tmpLeftArray[i];
                i++;
            } else {
                a[k] = tmpRightArray[j];
                j++;
            }
        }
    }


    private void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int array[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
        SortingHelper sh = SortingHelper.getInstance();
        int[] result = sh.sort(SortType.MergeSort, array);
        System.out.println("Merge Sort : ");
        sh.printArray(result);
        result = sh.sort(SortType.BubbleSort, array);
        System.out.println("Bubble Sort : ");
        sh.printArray(result);
        result = sh.sort(SortType.SelectionSort, array);
        System.out.println("Selection Sort : ");
        sh.printArray(result);
    }
}
