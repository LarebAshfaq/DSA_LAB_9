/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa_lab_9;

/**
 *
 * @author N TECH
 */
import java.util.LinkedList;
import java.util.Queue;

// Node class representing a tree node
class Node {
    int value;
    Node left, right;

    // Constructor
    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

// Binary Search Tree (BST) Class
class BinarySearchTree {
    private Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Insert method to add elements to the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Count the total number of nodes
    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }

    // Search for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.value) {
            return true;
        }
        if (value < root.value) {
            return searchRec(root.left, value);
        } else {
            return searchRec(root.right, value);
        }
    }

    // In-order Traversal: Left -> Root -> Right
    public void inOrderTraversal() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }

    // Pre-order Traversal: Root -> Left -> Right
    public void preOrderTraversal() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Post-order Traversal: Left -> Right -> Root
    public void postOrderTraversal() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Level-order Traversal (BFS)
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }
}

// Main class to test the BST
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements into the BST
        int[] elements = {50, 30, 20, 40, 70, 60, 80};
        System.out.println("Insertion Test:");
        for (int value : elements) {
            bst.insert(value);
            System.out.println("Inserted: " + value + ", Total Nodes: " + bst.countNodes());
        }

        // Search Test
        System.out.println("\nSearch Test:");
        int[] searchValues = {20, 60, 90};
        for (int value : searchValues) {
            System.out.println("Value " + value + (bst.search(value) ? " exists" : " does not exist") + " in the tree.");
        }

        // Traversal Tests
        System.out.println("\nTraversal Tests:");
        System.out.print("In-order Traversal: ");
        bst.inOrderTraversal();

        System.out.print("Pre-order Traversal: ");
        bst.preOrderTraversal();

        System.out.print("Post-order Traversal: ");
        bst.postOrderTraversal();

        System.out.print("Level-order Traversal: ");
        bst.levelOrderTraversal();
    }
}
