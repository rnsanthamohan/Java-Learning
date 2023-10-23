package com.misc.problems;

public class FibannocciSeries {

    public static void printFibannocciSeries(int n) {
        int a = 1;
        int b = 1;
        System.out.print(""+a+","+b);
        if (n >2) {
            for (int i = 2; i < n;i++) {
                int sum = a + b;
                a = b;
                b = sum;
                System.out.print(","+ b);
            }
        }
    }

    public static void main(String[] args) {
        FibannocciSeries.printFibannocciSeries(20);
    }
}
