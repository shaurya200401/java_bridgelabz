package dataStructures.TreesAndGraphs;

/*
 * PROBLEM: Find Height of a Binary Tree
 * Problem Statement:
 * Given the root of a binary tree, find the height (maximum depth) of the tree.
 * Input: Root of a binary tree
 * Output: Integer representing height
 * Concepts Tested:
 *  Recursion
 *  Tree traversal
 */
public class BinaryTreeHeight {

    // Node class for Binary Tree
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    // Method to find the height of the tree
    int findHeight(Node node) {
        if (node == null)
            return 0;
        else {
            // Compute the depth of each subtree
            int leftDepth = findHeight(node.left);
            int rightDepth = findHeight(node.right);

            // Use the larger one and add 1 for the current node
            if (leftDepth > rightDepth)
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }

    public static void main(String args[]) {
        BinaryTreeHeight tree = new BinaryTreeHeight();
        // Constructing tree
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Height of tree is : " + tree.findHeight(tree.root));
    }
}
