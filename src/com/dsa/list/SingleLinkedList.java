package com.dsa.list;

import com.dsa.model.SingleNode;

public class SingleLinkedList {

    private SingleNode head;
    private SingleNode tail;

    private int size;

    public SingleLinkedList(int value) {
        SingleNode node = new SingleNode();
        node.setData(value);
        this.head = node;
        this.tail = node;
        this.size = 1;
        System.out.println("SingleLinkedList created successfully");
        System.out.println(head);
    }

    public int getSize() {
        return this.size;
    }

    public void traverse() {
        if (head != null) {
            SingleNode currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        }
    }

    public SingleNode search(int value) {
        SingleNode result = null;
        if (head != null) {
            SingleNode currentNode = head;
            while (currentNode != null) {
                if (currentNode.data == value) {
                    System.out.println("Value found ... " + currentNode + " ");
                    result = currentNode;
                    break;
                }
                currentNode = currentNode.next;
            }
            if (result == null) {
                System.err.println("Value not found in the linked list...");
            }
        }
        return result;
    }

    public void insert(int location, int value) {
        if (location > size || location < 0) {
            System.err.println("Invalid Location!!!");
            return;
        }

        SingleNode newNode = new SingleNode();
        newNode.setData(value);
        System.out.println("Inserting...");
        if (location == 0) {
            newNode.setNext(head);
            head = newNode;
        } else if (location == size) {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            SingleNode currentNode = head;
            int i = 0;
            while (i != location-1) {
                currentNode = currentNode.next;
                i++;
            }
            newNode.setNext(currentNode.next);
            currentNode.setNext(newNode);
        }
        size = size + 1;
        System.out.println();
    }

    public void delete(int location) {
        if (location > size || location < 0) {
            System.err.println("Invalid Location!!!");
            return;
        }

        if (location == 0) { //if the location is head
            SingleNode tempNode = head.next;
            head.setNext(null);
            head = tempNode;
            size = size - 1;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size) { //tail node deletion
            SingleNode tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(null);
            tail = tempNode;
            size = size - 1;
        } else { //deleting any node in the middle
            SingleNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(tempNode.getNext().getNext());
            size = size - 1;
        }

    }

    public SingleNode getHead() {
        return head;
    }

    public void setHead(SingleNode head) {
        this.head = head;
    }

    public SingleNode getTail() {
        return tail;
    }

    public void setTail(SingleNode tail) {
        this.tail = tail;
    }

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList(10);
        sll.traverse();
        sll.search(10);
        sll.search(20);
        sll.insert(0, 1);
        sll.insert(1,2);
        sll.insert(2,3);
        sll.traverse();
        sll.search(2);
        sll.delete(3);
        sll.traverse();
    }
}
