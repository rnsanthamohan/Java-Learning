package com.dsa.stack;

import com.dsa.list.SingleLinkedList;

public class Stack {
    private int size;
    private int topOfStack;

    private SingleLinkedList list;

    public Stack(int size) {
        this.size = size;
    }

    public void push(int value) {
        if (isFull()) {
            System.err.println("Stack is full");
            return;
        }

        if (isEmpty()) {
            list = new SingleLinkedList(value);
        } else {
            list.insert(0, value);
        }
        topOfStack = topOfStack + 1;
    }

    public boolean isFull() {
        return (topOfStack == size);
    }

    public boolean isEmpty() {
        return (topOfStack == 0);
    }

    public int peek() {
        if (isEmpty()) {
            System.err.println("Stack is Empty");
            return -1;
        }
        return list.getHead().getData();
    }

    public int pop() {
        if (isEmpty()) {
            System.err.println("Stack is Empty");
            return -1;
        }
        int result = list.getHead().getData();
        list.delete(0);
        topOfStack = topOfStack - 1;
        return result;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(9);
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        System.out.println();
        stack.list.traverse();
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(111);
        stack.push(123);
        stack.list.traverse();
        System.out.println(stack.isFull());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
