package com.dsa.dp;

public class FibonacciSeriesTopDownApproach {
    public static int fibanocciSeries(int[] memoize, int n) {
        if (n < 1) {
            return -1;
        } else if (n == 1) {
            memoize[1] = 0;
        } else if (n == 2) {
            memoize[2] = 1;
        } else {
            if (memoize[n] == 0) {
                memoize[n] = fibanocciSeries(memoize, n - 1) + fibanocciSeries(memoize, n - 2);
            }
        }
        return memoize[n];
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 10;
        for (int i = 1; i <= n; i++) {
            int[] memoize = new int[i + 1];
            System.out.print(fibanocciSeries(memoize, i) + " ");
        }
        long end = System.nanoTime();
        System.out.println("Time taken : " + (end - start));
    }
}
