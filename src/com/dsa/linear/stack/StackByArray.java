package com.dsa.linear.stack;

import java.sql.SQLOutput;

public class StackByArray {
    private int size;
    private int top;
    private int[] data;

    public StackByArray(int size) {
        if (size > 0) {
            data = new int[size];
            this.size = size;
            top = -1;
            System.out.println("Stack created with size " + size);
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }

        data[top + 1] = value;
        top++;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        int result = Integer.valueOf(data[top]);
        data[top] = Integer.MIN_VALUE;
        top = top - 1;
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return data[top];
    }

    public static void main(String[] args) {
        StackByArray stack = new StackByArray(5);
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.isFull());
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.isFull());
        stack.pop();
        System.out.println(stack.peek());
    }
}
