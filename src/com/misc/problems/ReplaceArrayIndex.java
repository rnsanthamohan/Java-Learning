package com.misc.problems;

public class ReplaceArrayIndex {

    public static int[] replaceArrayElementsWithIndex(int[] array) {
        if (array != null) {
            for (int i = 0; i < array.length - 1; i++) {
                 if (array[i] != -1) {
                     array[i] = i;
                 }
            }
        }
        return array;
    }

    private static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        int[] result = ReplaceArrayIndex.replaceArrayElementsWithIndex(array);
        printArray(result);
    }
}
