package dataStructures.TreesAndGraphs;

import java.util.*;

/*
 * PROBLEM: BFS Traversal of a Graph
 * Problem Statement:
 * Given an undirected graph, perform Breadth First Search (BFS) starting from a given node.
 * Input:
 *  Number of vertices
 *  Edge list
 *  Starting node
 * Output: BFS traversal order
 * Concepts Tested:
 *  Queue
 *  Graph traversal
 */
public class GraphBFS {
    private int V; // No. of vertices

    // Adjacency Lists
    // Using LinkedList for dynamic list of neighbors
    private LinkedList<Integer> adj[];

    // Constructor
    GraphBFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        System.out.print("BFS Traversal: ");

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        GraphBFS g = new GraphBFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal (starting from vertex 2)");
        g.BFS(2);
    }
}
