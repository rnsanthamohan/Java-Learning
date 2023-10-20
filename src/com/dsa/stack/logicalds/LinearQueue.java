package com.dsa.stack.logicalds;

/**
 * Implementation of a linear queue using Array.
 * For the sake of simplicity using just integer array.
 */
public class LinearQueue {
    private int size;

    private int[] data;

    private int beginningOfQueue;
    private int topOfQueue;

    public LinearQueue(int size) {
        //initialize the queue with given size
        if (size > 0) { //if size is 0 or less than 0 throw error
            this.size = size;
            data = new int[this.size];
            topOfQueue = beginningOfQueue = -1; //set the pointers to -1
            System.out.println("Queue created with size " + size);
        } else {
            throw new RuntimeException("Size is less than or equal to zero");
        }
    }

    public void enqueue(int data){
        //if the queue is full do not enqueue
        if (isFull()) {
            System.err.println("Queue is full. Cannot enqueue");
            return;
        }
        this.data[topOfQueue + 1] = data;
        topOfQueue = topOfQueue + 1;
    }

    public boolean isFull() {
        return (topOfQueue == size-1);
    }

    public boolean isEmpty() {
        return (topOfQueue == -1);
    }

    public int dequeue() {
        if(isEmpty()) {
            System.err.println("Queue is empty. Cannot dequeue");
            return -1;
        }
        beginningOfQueue = beginningOfQueue +1;
        int result = data[beginningOfQueue];
        data[beginningOfQueue] = Integer.MIN_VALUE;
         if (beginningOfQueue >= topOfQueue) {
            beginningOfQueue = topOfQueue = -1;
        }
        System.out.println("Dequeued " + result);
        return result;
    }

    public int peek() {
        if(isEmpty()) {
            System.err.println("Queue is empty. Cannot dequeue");
            return -1;
        }
        int result = data[beginningOfQueue +1];
        System.out.println("Peek " + result);
        return result;
    }

    public void display() {
        if (!isEmpty()) {
            for (int item : data) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println(String.format("Beginning of Queue : %d Top of Queue : %d", beginningOfQueue, topOfQueue));
    }


    public static void main(String[] args) {
        LinearQueue q = new LinearQueue(5);
        q.display();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.enqueue(40);
        q.display();
        q.enqueue(50);
        q.display();
        q.enqueue(60);
        q.dequeue();
        q.dequeue();
        q.display();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.display();
        q.enqueue(100);
        q.display();
        q.peek();
    }
}
