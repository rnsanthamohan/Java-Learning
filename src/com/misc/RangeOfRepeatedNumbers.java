package com.misc;

import java.util.StringTokenizer;

public class RangeOfRepeatedNumbers {

    public static void findRangeOfRepeatedNumbers(String input) {
        int currentStartRange = 0;
        int currentEndRange = 0;
        int maxStartRange = 0;
        int maxEndRange = 0;
        int currentCount = 0;
        int maxCount = 0;
        String number = null;
        if (input != null && input.length() > 1) {
            String[] n = input.split(",");
            for (int i = 1; i < n.length; i++) {

                if (n[i].equals(n[i - 1])) {
                    currentCount++;
                    currentEndRange = i;
                } else {
                    if (currentCount > maxCount) {
                        maxCount = currentCount;
                        maxStartRange = currentStartRange;
                        maxEndRange = i-1;
                        number = n[i-1];
                    }
                    currentCount = 1;
                    currentStartRange = i;
                }
            }
            //if the last range is max then we need to check at the end of the loop.
            if (currentCount > maxCount) {
                maxStartRange = currentStartRange;
                maxEndRange = n.length - 1;
                number = n[n.length-1];
            }
            System.out.println("Range Start " + maxStartRange);
            System.out.println("Range End " + maxEndRange);
            System.out.println("Number " + number);
        }
    }

    public static void main(String[] args) {
        String input = "1,1,2,2,3,4,2,2,2,2,2,7,8,9,10,10,10,10,10,10,10,10";
        RangeOfRepeatedNumbers.findRangeOfRepeatedNumbers(input);
    }
}
