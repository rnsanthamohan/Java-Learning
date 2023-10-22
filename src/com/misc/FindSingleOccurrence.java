package com.misc;

public class FindSingleOccurrence {
    /**
     * In this code, we iterate through the array and XOR each element with the result variable.
     * Since XOR is commutative and associative, all the elements that occur twice will cancel
     * each other out, leaving only the single occurring element in the result variable.
     *
     * Running this code with the example array {4, 2, 3, 2, 4} will output:
     * The single occurring element is: 3
     * You can replace the arr variable with your own array to find the single occurring element in your data.
     * @param nums int[]
     * @return single occurring number
     */
    public static int findSingle(int[] nums) {
        int result = 0;

        for (int num : nums) {
            // XOR each element with the result
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 2, 4};
        int singleOccurrence = findSingle(arr);

        System.out.println("The single occurring element is: " + singleOccurrence);
    }
}
