package com.misc.problems;

public class Factorial {

    public static int factorial(int n) {
        int factorial = 1;
        if (n > 1) {
             factorial = n * factorial(n-1);
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(Factorial.factorial(6));
    }
}
