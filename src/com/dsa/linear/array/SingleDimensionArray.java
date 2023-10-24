package com.dsa.linear.array;

public class SingleDimensionArray {
    private int[] arr = null;

    public SingleDimensionArray(int size) {
        if (size > 0) {
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.MIN_VALUE;
            }
            System.out.println("Array create... Size = " + arr.length);
        }
    }

    public void insert(int position, int value) {
        if (arr != null) {
            if (position < 0 || position > arr.length) {
                System.err.println("Provide a valid position");
                return;
            } else {
                if (arr[position] == Integer.MIN_VALUE) {
                    arr[position] = value;
                    System.out.println(String.format("Value %d inserted in position %d", value, position));
                } else {
                    System.err.println("Position provided is already having a value");
                }
            }
        }
    }

    public void traversal() {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(String.format("%d = %d", i, arr[i]));
            }
        }
    }

    public boolean search(int value) {
        boolean match = false;
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == value) {
                    match = true;
                    System.out.println(String.format("%d is found in position %d", value, i));
                    break;
                }
            }
            if (!match) {
                System.err.println("Value not found in array");
            }
        }
        return match;
    }

    public void delete(int position) {
        if (arr != null) {
            if (position < 0 || position > arr.length) {
                System.err.println("Provide a valid position");
                return;
            } else {
                if (arr[position] == Integer.MIN_VALUE) {
                    System.err.println("Position provided is already empty");
                    return;
                } else {
                    arr[position] = Integer.MIN_VALUE;
                    System.out.println(String.format("Delete in position %d", position));
                }
            }
        }
    }

    public void deleteArray() {
        if (arr != null) {
            arr = null;
            System.out.println("Array deleted successfully");
        }
    }

    public static void main(String[] args) {
        SingleDimensionArray sda = new SingleDimensionArray(10);

        sda.insert(0, 10);
        sda.insert(1, 20);
        sda.search(20);
        sda.search(30);
        sda.traversal();
        sda.delete(1);
        sda.search(20);
        sda.traversal();
        sda.deleteArray();
    }
}
