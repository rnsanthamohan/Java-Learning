package com.core.basics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

interface FuncInterface
{
    // An abstract function
    void twoTimes(int x);

    // A non-abstract (or default) function
    default void normalFun()
    {
        System.out.println("Hello");
    }
}

interface IFunction {
    int operation(int x, int y);
}


public class LambdaExpressions {

    public int calculate(int x, int y, IFunction iFunc) {
        return iFunc.operation(x, y);
    }

    public static void main(String[] args) {
        // lambda expression to implement above
        // functional interface. This interface
        // by default implements abstractFun()
        FuncInterface fobj = (int x)->System.out.print((2*x) + " ");
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach((n) -> {fobj.twoTimes(n);});
        System.out.println();
        // Using lambda expression to print even elements
        // of arrL
        numbers.forEach(n -> {
            if (n % 2 == 0)
                System.out.println(n);
        });
        System.out.println();
        Consumer<Integer> method = (n) -> { System.out.print(n + " "); };
        numbers.forEach( method );

        IFunction add = (int x, int y) -> x + y;
        IFunction multiple = (int x, int y) -> x * y;

        LambdaExpressions le = new LambdaExpressions();
        int result = le.calculate(3, 5, add);
        System.out.println("Add : " + result);
        result = le.calculate(4, 4, multiple);
        System.out.println("Multiply : " + result);
    }
}
