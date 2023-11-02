package com.core.basics;

/**
 * Let’s look at a sample code where count is a shared resource. The consumer thread will wait inside the
 * consume() method on the producer thread, until the producer thread increments the count inside the produce()
 * method and subsequently notifies the consumer thread. Once it has been notified, the consumer thread waiting
 * inside the consume() method will give up its waiting state and completes its method by consuming the count (i.e.
 * decrementing the count).
 */
public class ConsumerProducer {

    public int count; //shared resource

    public synchronized void consumer() {
        try {
            while (count == 0) {
                System.out.println("<<" + count);
                wait();
            }
            count--;
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted " + e.getLocalizedMessage());
        }
    }

    public synchronized void producer() {
        count = count + 1;
        System.out.println(">>" + count);
        notify();
    }

    public static void main(String[] args) {
        ConsumerProducer cp = new ConsumerProducer();
        cp.producer();
        cp.consumer();
        cp.consumer();
        cp.producer();
    }
}
