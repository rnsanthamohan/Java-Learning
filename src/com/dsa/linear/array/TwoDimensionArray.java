package com.dsa.linear.array;

public class TwoDimensionArray {

    private int[][] arr = null;
    private int rows;
    private int cols;

    public TwoDimensionArray(int rows, int cols) {
        if (rows > 0 && cols > 0) {
            this.rows = rows;
            this.cols = cols;
            arr = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    arr[r][c] = Integer.MIN_VALUE;
                }
            }
            System.out.println(String.format("Array with rows %d and Cols %d created successfully", rows, cols));
        }
    }

    public void insert(int row, int col, int value) {
        if (arr != null) {
            try {
                if (arr[row][col] == Integer.MIN_VALUE) {
                    arr[row][col] = value;
                    System.out.println(String.format("Inserted value %d at position %d, %d", value, row, col));
                } else {
                    System.err.println("Cannot insert at this position as array is occupied here..");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Invalid Index provided" + e.getMessage());
            }
        }
    }

    public void traversal() {
        if (arr != null) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    System.out.print(arr[r][c] + " ");
                }
                System.out.println();
            }
        }
    }

    public boolean search(int value) {
        boolean matched = false;
        if (arr != null) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (arr[r][c] == value) {
                        matched = true;
                        System.out.println(String.format("Found value %d at position %d, %d", value, r, c));
                        break;
                    }

                }
            }
            if (!matched) {
                System.err.println("Value is not found in the array!!!");
            }
        }
        return matched;
    }

    public void delete(int row, int col) {
        if (arr != null) {
            try {
                if (arr[row][col] == Integer.MIN_VALUE) {
                    System.err.println("Array Position is already empty");
                } else {
                    arr[row][col] = Integer.MIN_VALUE;
                    System.out.println("Deleted successfully..");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Invalid Index provided" + e.getMessage());
            }
        }
    }

    public void deleteArray() {
        if (arr != null) {
            arr = null;
            System.out.println("Array Deleted successfully..");
        }
    }

    public static void main(String[] args) {
        System.out.println("Creating a blank array of size 5X5...");
        TwoDimensionArray sda = new TwoDimensionArray(5,5);
        sda.traversal();

        sda.insert(0,1,1000000000);
        sda.insert(0,2,1000000001);
        sda.insert(0,3,1000000002);
        sda.traversal();

        sda.search(1000000001);
        sda.search(1000000011);
        sda.traversal();

        sda.delete(0, 1);
        sda.delete(1, 1);
        sda.traversal();
        sda.deleteArray();
        sda.traversal();
    }
}
