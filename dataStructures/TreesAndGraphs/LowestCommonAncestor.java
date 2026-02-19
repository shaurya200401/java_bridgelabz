package dataStructures.TreesAndGraphs;

/*
 * PROBLEM: Lowest Common Ancestor (LCA) of a Binary Tree
 * Problem Statement:
 * Given a binary tree and two nodes p and q, find their lowest common ancestor.
 * Concepts Tested:
 *  Recursion
 *  Tree traversal logic
 */
public class LowestCommonAncestor {

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    // Method to find LCA given two values n1 and n2
    Node findLCA(Node node, int n1, int n2) {
        if (node == null)
            return null;

        // If either n1 or n2 matches the current node, this is the LCA (or one of the
        // nodes)
        if (node.data == n1 || node.data == n2)
            return node;

        // Look for keys in left and right subtrees
        Node leftLCA = findLCA(node.left, n1, n2);
        Node rightLCA = findLCA(node.right, n1, n2);

        // If both return non-null, this node is the LCA
        if (leftLCA != null && rightLCA != null)
            return node;

        // Otherwise return the non-null child (or null if both are null)
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String args[]) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        // 1
        // / \
        // 2 3
        // / \ / \
        // 4 5 6 7
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        // LCA of 4 and 5 should be 2
        Node lca = tree.findLCA(tree.root, 4, 5);
        if (lca != null)
            System.out.println("LCA of 4 and 5 is: " + lca.data);
        else
            System.out.println("LCA not found");

        // LCA of 4 and 6 should be 1
        lca = tree.findLCA(tree.root, 4, 6);
        if (lca != null)
            System.out.println("LCA of 4 and 6 is: " + lca.data);
    }
}
