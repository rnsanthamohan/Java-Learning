package com.misc;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] array, int target) {
        int[] result = new int[] {0};
        if (array != null) {
            Map<Integer, Integer> numberMap = new HashMap<>();

            for (int i = 0; i < array.length; i++) {
                int complement = target - array[i];

                if (numberMap.containsKey(complement)) {
                    result = new int[]{numberMap.get(complement), i};
                    break;
                } else {
                    numberMap.put(array[i], i);
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 3,5,6,1,7};
        int target = 10;
        int[] result = twoSum(nums, target);

        if (result.length == 2) {
            System.out.println("The indices of the two numbers that sum to " + target + " are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}
