package com.dsa.nonlinear.tree;

import com.dsa.model.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public BinaryNode root;

   public BinarySearchTree() {
       root = null;
   }

   public void insert(int value) {
       root = insert(root, value);
   }

   public BinaryNode insert(BinaryNode currentNode, int value) {
       if (currentNode == null) {
           BinaryNode newNode = new BinaryNode();
           newNode.setValue(value);
           return newNode;
       }

       if (value <= currentNode.getValue()) {
           currentNode.setLeft(insert(currentNode.getLeft(), value));
       } else if (value > currentNode.getValue()) {
           currentNode.setRight(insert(currentNode.getRight(), value));
       }
       return currentNode;
   }

   public void search(int value) {
       search(root, value);
   }

   public BinaryNode search(BinaryNode node, int value) {
       BinaryNode result = null;
       if (node == null) {
           System.err.println("Node is empty and cannot perform search...");
           return result;
       }

       if (node.getValue() == value) {
           result = node;
           System.out.println("Found node match for value " + value);
           return result;
       } else if (node.getValue() < value) {
           //traverse through right tree
           search(node.getRight(), value);
       } else if (node.getValue() > value) {
           //traverse through left tree
           search(node.getLeft(), value);
       }
       return result;
   }

   public void preOrder(BinaryNode root) {
       if (root == null) {
           return;
       }

       System.out.print(root.getValue() + " ");
       preOrder(root.getLeft());
       preOrder(root.getRight());
   }

    public void inOrder(BinaryNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
    }

    public void postOrder(BinaryNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    public void levelOrder() {
        if (root == null) {
            System.err.println("Node is empty and cannot perform search...");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            System.out.print(node.getValue() + " ");
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }

    void printTreeGraphically() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        Queue<Integer> level = new LinkedList<Integer>();

        int CurrentLevel = 1;
        boolean previousLevelWasAllNull = false;
        queue.add(root);
        level.add(1);

        System.out.println("\nPrinting Level order traversal of Tree...");
        if(root == null) {
            System.out.println("Tree does not exists !");
            return;
        }

        while (!queue.isEmpty()) {
            if(CurrentLevel == level.peek()) { //if we are in the same level
                if(queue.peek()==null) {
                    queue.add(null);level.add(CurrentLevel+1);
                }else {
                    queue.add(queue.peek().getLeft());level.add(CurrentLevel+1);
                    queue.add(queue.peek().getRight());level.add(CurrentLevel+1);
                    previousLevelWasAllNull = false;
                }
                System.out.print(queue.remove() + "  ");level.remove();
            }else { //level has changed
                System.out.println("\n");
                CurrentLevel++;
                if(previousLevelWasAllNull == true) {
                    break;
                }
                previousLevelWasAllNull = true;
            }
        }//end of loop
    }//end of method

    public static void main(String[] args) {
//Constructor
        BinarySearchTree tree = new BinarySearchTree();

        //Inserting values in BST
        System.out.println("Inserting 10 nodes in Tree");
        tree.insert(100);
        tree.insert(80);
        tree.insert(70);
        tree.insert(90);
        tree.insert(50);
        tree.levelOrder();

        System.out.println("\nIn-order of tree:");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.println("\nPre-order of tree:");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("\nPost-order of tree:");
        tree.postOrder(tree.root);
        System.out.println();

        //Searching non-existing value in Tree
        System.out.println("\n\nSearching for value on BST...");
        tree.search(80);

        //Searching existing value in Tree
        System.out.println("\nSearching for value on BST...");
        tree.search(60);
        tree.printTreeGraphically();
    }
}
