package list;

import model.DoubleNode;

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

    }

    public void search(int value) {

    }

    public void traversal() {

    }

    public void delete(int position) {

    }

    public void deleteList() {

    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(10);
        System.out.println("Size of DLL : " + dll.getSize());
        System.out.println("HasItems in DLL : " + dll.hasItems());
    }
}
