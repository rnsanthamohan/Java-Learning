package com.dsa.linear.list;

import com.dsa.model.SingleNode;

public class CircularSingleLinkedList {

    private SingleNode head;
    private SingleNode tail;
    private int size;

    public CircularSingleLinkedList(int value) {
        SingleNode node = new SingleNode();
        node.setData(value);
        node.setNext(node);
        this.head = node;
        this.tail = node;
        this.size = 1;
        System.out.println("Circular Single LinkedList is created successfully " + node.data);
    }

    public int getSize() {
        return size;
    }

    public boolean exists() {
        return head != null;
    }


    public void insert(int location, int value) {
        if (!exists()) {
            System.err.println("CircularSingleLinkedList is not created or does not exist. Create one..");
            return;
        }

        SingleNode newNode = new SingleNode();
        newNode.setData(value);
        if (location == 0) { //inserting at head
            newNode.setNext(head);
            head = newNode;
            tail.setNext(newNode);
            System.out.println("Node inserted at head " + newNode.data);
        } else if (location == size || location > size) { //inserting at tail
            SingleNode currentNode = head;
            for (int i = 0; i < size-1; i++) {
                currentNode = currentNode.next;
            }
            newNode.setNext(head);
            currentNode.setNext(newNode);
            tail = newNode;
            System.out.println("Node inserted at tail " + newNode.data);
        } else {
            SingleNode currentNode = head;
            for (int i = 0; i < location - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            System.out.println("Node inserted at position " + location);
        }
        size = size + 1;
    }

    public SingleNode search(int value) {
        SingleNode result = null;
        if (exists()) {
            SingleNode currentNode = head;
            for (int i = 0; i < size; i++) {
                if (currentNode.data == value) {
                    result = currentNode;
                    System.out.println("Found value " + value + " in node " + currentNode.data + " ");
                    break;
                }
                currentNode = currentNode.next;
            }
            if (result == null) {
                System.err.println(" Value not found in list");
            }
        } else {
            System.err.println("Circular Single LinkedList does not exist");
        }
        return result;
    }

    public void traversal() {
        if (exists()) {
            SingleNode currentNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
            System.out.println();
        } else {
            System.err.println("Circular Single LinkedList does not exist");
        }
    }

    public void deleteList() {
        if (exists()) {
            head = null;
            tail = null;
        }
    }

    public void delete(int location) {
        if (!exists()) {
            System.err.println("CircularSingleLinkedList is not created or does not exist. Create one..");
            return;
        }

        if (location < 0 || location > size) {
            System.err.println("Invalid location..");
            return;
        }

        if (location == 0) { //deleting at the head
            head = head.next;
            tail.next = head;
        } else if (location == size) { //deleting at tail
            SingleNode currentNode = head;
            for (int i = 0; i < size-1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.setNext(head);
            tail = currentNode;
            System.out.println("Node deleted at tail. Current tail " + tail.data);
        } else {
            SingleNode currentNode = head;
            for (int i = 0; i < location - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.setNext(currentNode.getNext().getNext());
            System.out.println("Node deleted at position " + location);
        }
        size = size - 1;
    }

    public static void main(String[] args) {
        CircularSingleLinkedList csll = new CircularSingleLinkedList(10);
        System.out.println(csll.exists());
        csll.traversal();
        csll.insert(0,1);
        csll.insert(1, 2);
        csll.insert(csll.getSize(), 100);
        csll.insert(csll.getSize(), 101);
        csll.insert(csll.getSize(), 102);
        System.out.println("Head " + csll.head.data + " Tail " + csll.tail.data);
        csll.traversal();
        csll.search(101);
        csll.delete(-1);
        csll.delete(0);
        System.out.println("Head " + csll.head.data + " Tail " + csll.tail.data);
        csll.traversal();
        csll.delete(csll.getSize());
        System.out.println("Head " + csll.head.data + " Tail " + csll.tail.data);
        csll.traversal();
        csll.delete(1);
        System.out.println("Head " + csll.head.data + " Tail " + csll.tail.data);
        csll.traversal();
    }

}
