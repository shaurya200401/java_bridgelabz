package dataStructures.TreesAndGraphs;

/*
 * PROBLEM: Count Leaf Nodes
 * Problem Statement:
 * Given a binary tree, count the number of leaf nodes (nodes with no children).
 * Input: Root of the tree
 * Output: Number of leaf nodes
 * Concepts Tested:
 *  Tree traversal
 *  Base condition handling
 */
public class CountLeafNodes {

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

    // Method to count leaf nodes
    int countLeaves(Node node) {
        if (node == null)
            return 0;
        
        // If leaf node (no children), return 1
        if (node.left == null && node.right == null)
            return 1;
        
        // Recur for left and right subtrees
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public static void main(String args[]) {
        CountLeafNodes tree = new CountLeafNodes();
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
        
        // Leaves are 3, 4, 5
        System.out.println("Count of leaf nodes is : " + tree.countLeaves(tree.root));
    }
}
