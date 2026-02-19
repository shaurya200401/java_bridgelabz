package dataStructures.TreesAndGraphs;

/*
 * PROBLEM: Diameter of a Binary Tree
 * Problem Statement:
 * Find the diameter of a binary tree.
 * The diameter is the length of the longest path between any two nodes.
 * Constraints:
 *  The path may or may not pass through the root
 * Concepts Tested:
 *  Recursion optimization
 *  Height + diameter logic
 */
public class BinaryTreeDiameter {

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;
    // Tracks maximum diameter found so far
    int maxDiameter = 0;

    // Method to calculate height and update diameter
    int height(Node node) {
        if (node == null)
            return 0;

        // Calculate height of left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update global maxDiameter if path through this node is larger
        // Diameter passing through this node = leftHeight + rightHeight
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    int getDiameter(Node node) {
        maxDiameter = 0; // reset
        height(node);
        return maxDiameter;
    }

    public static void main(String args[]) {
        BinaryTreeDiameter tree = new BinaryTreeDiameter();
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // Diameter is 3 (path: 4 -> 2 -> 1 -> 3 or 5 -> 2 -> 1 -> 3)
        // Heights are in terms of nodes in path usually, but problem says "length of
        // biggest path"
        // sometimes length is edges, sometimes nodes.
        // If edges: path 4-2-1-3 has 3 edges.
        // If nodes: path 4-2-1-3 has 4 nodes.
        // Standard LeetCode definition is edges (length of path = number of edges).
        // My code calculates: leftHeight + rightHeight.
        // If height is # of nodes, then 1-node tree has height 1. 2-node has 2.
        // Path 4(H=1)-2(H=2)-1(H=3). Left=2, Right=1 (node 3). 2+1 = 3.
        // So this corresponds to Edge count/length.

        System.out.println("Diameter of tree is : " + tree.getDiameter(tree.root));
    }
}
