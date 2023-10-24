package com.dsa.linear.queue;

/**
 * Implementation of a circular queue using array.
 * For simplicity, using just an integer array
 */
public class CircularQueue {
    private int start;
    private int topOfQueue;
    private int size;
    private int[] data;

    public CircularQueue(int size) {
        if (size <= 0) {
            throw new RuntimeException("Size cannot be 0 or lt 0");
        }

        this.size = size;
        this.data = new int[size];
        start = topOfQueue = -1;
        System.out.println("Created a circular array with size " + size);
    }

    public void enqueue(int value) {
        if (isQueueFull()) {
            System.err.println("Queue is full. Cannot Enqueue");
            return;
        }
        if (start == -1) {
            start = 0;
        }
        if (topOfQueue + 1 == size) {
            //if the top of the queue is at the end of the queue, move it back to start
            topOfQueue = 0;
        } else {
            topOfQueue = topOfQueue + 1;
        }
        this.data[topOfQueue] = value;
        System.out.println(String.format("Inserted value %d at position %d", value, topOfQueue));
    }

    public int deQueue() {
        if (isQueueEmpty()) {
            System.err.println("Queue is Empty. Cannot Dequeue");
            return -1;
        }

        int result = this.data[start];
        this.data[start] = Integer.MIN_VALUE;
        if (topOfQueue == start) {
            //if there is only one element in the queue
            start = topOfQueue = -1;
        } else if (start + 1 == size) {
            //if the start pointer is at the end of queue
            start = 0;
        } else {
            //if the start pointer is in the middle trivial case
            start++;
        }
        System.out.println("Dequeued value " + result);
        return result;
    }

    public int peek() {
        if (isQueueEmpty()) {
            System.err.println("Queue is Empty. Cannot Dequeue");
            return -1;
        }

        int result = this.data[start];
        System.out.println("Peek value " + result);
        return result;
    }

    public boolean isQueueFull() {
        if (topOfQueue + 1 == start) {
            return true;
        } else if (start <= 0 && topOfQueue + 1 == size){
            return true;
        }
        return false;
    }

    public boolean isQueueEmpty() {
        //if the top pointer is -1 then the queue is empty
        return (topOfQueue == -1);
    }

    public void display() {
        if (!isQueueEmpty()) {
            for (int item : data) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println(String.format("Start of Queue : %d Top of Queue : %d", start, topOfQueue));
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        System.out.println("Is Empty : " + cq.isQueueEmpty() + " Is Full " + cq.isQueueFull());
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        cq.peek();
        cq.display();
        System.out.println("Is Empty : " + cq.isQueueEmpty() + " Is Full " + cq.isQueueFull());
        cq.deQueue();
        cq.display();
        System.out.println("Is Empty : " + cq.isQueueEmpty() + " Is Full " + cq.isQueueFull());
        cq.deQueue();
        cq.deQueue();
        cq.deQueue();
        cq.peek();
        cq.deQueue();
        cq.display();
        System.out.println("Is Empty : " + cq.isQueueEmpty() + " Is Full " + cq.isQueueFull());
        cq.enqueue(60);
        cq.deQueue();
        System.out.println("Is Empty : " + cq.isQueueEmpty() + " Is Full " + cq.isQueueFull());
    }
}
