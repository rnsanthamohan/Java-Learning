package com.dsa.linear.list;

import com.dsa.model.DoubleNode;

public class DoublyLinkedList {
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    public DoublyLinkedList(int value) {
        DoubleNode node = new DoubleNode();
        node.setValue(value);
        head = node;
        tail = node;
        size = size + 1;
        System.out.println("DoublyLinkedList is created with value " + node.getValue());
    }

    private void incrementSize() {
        this.size = size + 1;
    }

    private void decrement() {
        this.size = size - 1;
    }

    public int getSize() {
       return size;
    }

    public boolean hasItems() {
        return (head != null);
    }

    public void insert(int location, int value) {
        if (!hasItems()) {
            System.err.println("DoubleLinkedList is not created!!");
            return;
        }

        DoubleNode newNode = new DoubleNode();
        newNode.setValue(value);
        if (location == 0) { //insert at head
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
            System.out.println("Inserted value at head " + newNode.getValue());
        } else if (location == size) { //inserting at tail
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        } else {
            DoubleNode currentNode = head;
            for (int i = 0; i < location; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.getPrevious().setNext(newNode);
            newNode.setPrevious(currentNode.getPrevious());
            newNode.setNext(currentNode);
            currentNode.setPrevious(newNode);
        }
        incrementSize();
    }

    public DoubleNode search(int value) {
        DoubleNode result = null;
        if (!hasItems()) {
            System.err.println("No items to search!!");
            return result;
        }

        DoubleNode currentNode = head;
        for (int i = 0; i < getSize(); i++) {
            if (currentNode.getValue() == value) {
                System.out.println("Value found ... " + currentNode.getValue() + " ");
                result = currentNode;
                break;
            }
            currentNode = currentNode.getNext();
        }

        if (result == null) {
            System.err.println("Value " + value + " not found ... ");
        }
        return result;
    }

    public void traversalForward() {
        if (!hasItems()) {
            System.err.println("No items to traverse!!");
            return;
        }

        DoubleNode currentNode = head;
        for (int i = 0; i < getSize(); i++) {
            display(currentNode);
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public void traversalBackwards() {
        if (!hasItems()) {
            System.err.println("No items to traverse!!");
            return;
        }

        DoubleNode currentNode = tail;
        for (int i = getSize() -1; i >= 0; i--) {
            display(currentNode);
            currentNode = currentNode.getPrevious();
        }
        System.out.println();
    }

    public void delete(int location) {
        if (!hasItems()) {
            System.err.println("No items to delete!!");
            return;
        }

        if (location == 0) { //insert at head
            head.getNext().setPrevious(null);
            head = head.getNext();
            System.out.println("Deleted head. New head " + head.getValue());
        } else if (location == size) { //inserting at tail
            tail.getPrevious().setNext(null);
            tail = tail.getPrevious();
            System.out.println("Deleted tail. New tail " + tail.getValue());
        } else {
            DoubleNode currentNode = head;
            for (int i = 0; i < location; i++) {
                currentNode = currentNode.getNext();
            }
            DoubleNode previousNode = currentNode.getPrevious();
            previousNode.setNext(currentNode.getNext());
            currentNode.getNext().setPrevious(previousNode);
        }
        decrement();

    }

    public void deleteList() {
        if (hasItems()) {
            head = null;
            tail = null;
        }
    }

    public void display(DoubleNode node) {
        System.out.print("[" + node.getPrevious() + ", " + node.getValue() + ", " + node.getNext() + "]");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(10);
        System.out.println("Size of DLL : " + dll.getSize());
        System.out.println("HasItems in DLL : " + dll.hasItems());
        dll.insert(0,1);
        dll.insert(1, 2);
        dll.insert(2, 3);
        dll.search(10);
        dll.traversalForward();
        dll.traversalBackwards();
        dll.delete(0);
        dll.traversalForward();
        dll.delete(1);
        dll.traversalForward();
        dll.delete(dll.getSize());
    }
}
