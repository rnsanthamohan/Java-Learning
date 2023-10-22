package com.misc;

public class BalancedStrings {

    public static int countBalancedStrings(String input) {
        int count = 0;
        int balance = 0;
        if (input != null && input.length() > 1) {
            char[] chars = input.toCharArray();

            for (char c : chars) {
                switch (c) {
                    case 'L':
                        balance = balance + 1;
                        break;
                    case 'R':
                        balance = balance - 1;
                        break;
                }
                if (balance == 0) {
                    count = count + 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] inputs = {"RLRRLL","RLRRLLRLRL","LLLLRRRR","RLLLLRRRLR"};
        for (String input : inputs) {
            int count = BalancedStrings.countBalancedStrings(input);
            System.out.println(String.format("Input %s Count %d", input, count));
        }
    }
}
