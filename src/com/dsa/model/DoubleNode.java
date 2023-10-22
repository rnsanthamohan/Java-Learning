package com.dsa.model;

public class DoubleNode {
    private DoubleNode previous;
    private DoubleNode next;
    private int value;

    public DoubleNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
