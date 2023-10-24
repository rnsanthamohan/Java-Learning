package com.dsa.linear.queue;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> s1 = new Stack();
    private Stack<Integer> s2 = new Stack<>();

    /**
     * enQueue(x):
     *
     * While stack1 is not empty, push everything from stack1 to stack2.
     * Push x to stack1 (assuming size of stacks is unlimited).
     * Push everything back to stack1.
     * Here time complexity will be O(n)
     * @param x
     */
    public void enQueue(int x) {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }

        s1.push(x);

        while(!s2.empty()) {
            s1.push(s2.pop());
        }
    }

    /**
     * deQueue():
     *
     * If stack1 is empty then error
     * Pop an item from stack1 and return it
     * Here time complexity will be O(1)
     * @return
     */
    public int deQueue() {
        if (s1.empty()) {
            return -1;
        }

        return s1.pop();
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
