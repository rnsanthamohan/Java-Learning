package com.algorithms.sorting;

public class FibonnaciSeriesUsingDC {

    public static int fibonnaciSeries(int n) {
        if (n < 1) {
            return -1;
        } else if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonnaciSeries(n-1) + fibonnaciSeries(n-2);
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 10;
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonnaciSeries(i) + " ");
        }
        long end = System.nanoTime();
        System.out.println("Time taken : " + (end - start));
    }
}
