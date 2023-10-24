package com.dsa.nonlinear.tree;

import com.dsa.model.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUsingLL {
    public BinaryNode root;

    public BinaryTreeUsingLL() {
        this.root = null;
    }

    public void insert(int value) {
        BinaryNode newNode = new BinaryNode();
        newNode.setValue(value);
        //if root not present, set the node as root
        if (root == null) {
            root = newNode;
            System.out.println("Insert value " + value + " at the root");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.getLeft() == null) {
                presentNode.setLeft(newNode);
                System.out.println("Insert value " + value + " at the left");
                break;
            } else if (presentNode.getRight() == null) {
                presentNode.setRight(newNode);
                System.out.println("Insert value " + value + " at the right");
                break;
            } else {
                queue.add(presentNode.getLeft());
                queue.add(presentNode.getRight());
            }
        }
    }

    public BinaryNode search(int value) {
        BinaryNode result = null;
        if (root == null) {
            System.err.println("Root is empty and cannot search...");
            return result;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.getValue() == value) {
                result = presentNode;
                System.out.print("Found Node matching " + value);
                break;
            }
            if (presentNode.getLeft() != null) {
                queue.add(presentNode.getLeft());
            }
            if (presentNode.getRight() != null) {
                queue.add(presentNode.getRight());
            }
        }
        if (result == null) {
            System.err.print("Could not find Node matching " + value);
        }
        return result;
    }

    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrder(node.getRight());
    }

    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void levelOrder() {
        if (root == null) {
            System.err.println("Root is empty and cannot traverse...");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.getValue() + " ");
            if (presentNode.getLeft() != null) {
                queue.add(presentNode.getLeft());
            }
            if (presentNode.getRight() != null) {
                queue.add(presentNode.getRight());
            }
        }
    }

    public void deleteNode(int value) {
        if (root == null) {
            System.err.println("Root is empty and cannot delete node...");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.getValue() == value) {
                BinaryNode deepestNode = getDeepestNode();
                presentNode.setValue(deepestNode.getValue());
                deleteDeepestNode();
                return;
            }

            if (presentNode.getLeft() != null) {
                queue.add(presentNode.getLeft());
            }
            if (presentNode.getRight() != null) {
                queue.add(presentNode.getRight());
            }
        }
    }

    private void deleteDeepestNode() {
        if (root == null) {
            System.err.println("Root is empty and cannot get deepest node...");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode previousNode, presentNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.getLeft() == null) {
                previousNode.setRight(null);
                break;
            }
            if (presentNode.getRight() == null) {
                presentNode.setLeft(null);
                break;
            }
            queue.add(presentNode.getLeft());
            queue.add(presentNode.getRight());
        }
    }

    public BinaryNode getDeepestNode() {
        BinaryNode presentNode = null;
        if (root == null) {
            System.err.println("Root is empty and cannot get deepest node...");
            return presentNode;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            presentNode = queue.remove();
            if (presentNode.getLeft() != null) {
                queue.add(presentNode.getLeft());
            }
            if (presentNode.getRight() != null) {
                queue.add(presentNode.getRight());
            }
        }
        System.out.println("Deepest node " + presentNode.getValue());
        return presentNode;
    }

    public void deleteTree() {
        root = null;
        System.out.println("Deleted tree successfully");
    }
    public static void main(String[] args) {
        //Create a blank Tree
        BinaryTreeUsingLL tree = new BinaryTreeUsingLL();


        //Insert 10 nodes in the tree
        System.out.println("Inserting 10 nodes to tree");
        for(int i=1;i<=10;i++)
            tree.insert(i*10);

        System.out.println("\nLevel-order of tree:");
        tree.levelOrder();
        System.out.println();

        System.out.println("\nPre-order of tree:");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("\nPost-order of tree:");
        tree.postOrder(tree.root);
        System.out.println();

        System.out.println("\nIn-order of tree:");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.println("\nSearching node 50 in the tree...");
        tree.search(50);


        System.out.println("\nSearching node 500 in the tree...");
        tree.search(500);

        System.out.println("\nFind deepest node in the tree...");
        System.out.println(tree.getDeepestNode().getValue());

        System.out.println("\nDeleting node having value-5 in the tree...");
        tree.deleteNode(5);


        System.out.println("\nDeleting node having value-50 in the tree...");
        tree.deleteNode(50);
        tree.levelOrder();

        System.out.println("\n\nDeleting node having value-10 in the tree...");
        tree.deleteNode(10);
        tree.levelOrder();

        System.out.println("\n\nDeleting node having value-80 in the tree...");
        tree.deleteNode(80);
        tree.levelOrder();
    }
}
