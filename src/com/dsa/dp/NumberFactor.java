package com.dsa.dp;

public class NumberFactor {

    public static int findNumberFactor(int n) {
        int dp[] = new int[n + 1];
        if (n == 0) {
            dp[0] = 1;
        } else if (n == 1) {
            dp[1] = 1;
        } else if (n == 2) {
            dp[2] = 1;
        } else if (n == 3) {
            dp[3] = 2;
        } else {
                    if (dp[n] == 0) {
                        int sub1 = findNumberFactor(n-1);
                        int sub2 = findNumberFactor(n-3);
                        int sub3 = findNumberFactor(n-4);
                        dp[n] = sub1 + sub2 + sub3;
                    }
        }
           return dp[n];
    }

    public static void main(String[] args) {
        int result = NumberFactor.findNumberFactor(7);
        System.out.println(result);
    }
}
