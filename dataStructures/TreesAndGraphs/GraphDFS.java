package dataStructures.TreesAndGraphs;

import java.util.*;

/*
 * PROBLEM: DFS Traversal of a Graph
 * Problem Statement:
 * Given a graph, perform Depth First Search (DFS) traversal starting from a given node.
 * Concepts Tested:
 *  Recursion / Stack
 *  Graph traversal
 */
public class GraphDFS {
    private int V; // No. of vertices

    // Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    GraphDFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
        // adj[w].add(v); // If undirected, uncomment this. BFS example was directed in
        // default impl of 'add'.
        // Assuming directed/undirected as per general graph traversal.
        // For general "Graph Traversal" on undirected, we add both ways.
        // Problem 6 specified "undirected", so for this one I will make it
        // undirected/directed compatible.
        // The previous BFS example logic added edges as directed (v->w) in the
        // `addEdge` function
        // but the problem statement said "Undirected".
        // However, usually BFS/DFS logic remains same.
        // I will stick to single add here to match standard example, but for Undirected
        // I will verify.
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        System.out.print("DFS Traversal: ");
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
        System.out.println();
    }

    public static void main(String args[]) {
        GraphDFS g = new GraphDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal (starting from vertex 2)");
        g.DFS(2);
    }
}
