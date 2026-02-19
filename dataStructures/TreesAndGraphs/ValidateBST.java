package dataStructures.TreesAndGraphs;

/*
 * PROBLEM: Validate Binary Search Tree
 * Problem Statement:
 * Given a binary tree, determine whether it is a valid Binary Search Tree (BST).
 * Rules:
 *  Left subtree values < root
 *  Right subtree values > root
 * Concepts Tested:
 *  BST properties
 *  Inorder traversal
 */
public class ValidateBST {

    // Node class
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    // Method to check if BST
    // Uses min/max range constraints for each node
    boolean isValidBST(Node node, Integer min, Integer max) {
        if (node == null)
            return true;

        // Check if current node violates min/max constraints
        if ((min != null && node.data <= min) || (max != null && node.data >= max))
            return false;

        // Recur checking bounds for left and right subtrees
        // Left child must be < current node (max becomes node.data)
        // Right child must be > current node (min becomes node.data)
        return isValidBST(node.left, min, node.data) && isValidBST(node.right, node.data, max);
    }

    public static void main(String args[]) {
        ValidateBST tree = new ValidateBST();
        // Valid BST
        // 4
        // / \
        // 2 5
        // / \
        // 1 3
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isValidBST(tree.root, null, null))
            System.out.println("Tree 1 is a valid BST");
        else
            System.out.println("Tree 1 is NOT a valid BST");

        // Invalid case
        // 4
        // / \
        // 2 5
        // / \
        // 1 6 <-- 6 > 4, but is in left subtree!
        tree.root.left.right.data = 6;
        if (tree.isValidBST(tree.root, null, null))
            System.out.println("Tree 2 is a valid BST");
        else
            System.out.println("Tree 2 is NOT a valid BST");
    }
}
