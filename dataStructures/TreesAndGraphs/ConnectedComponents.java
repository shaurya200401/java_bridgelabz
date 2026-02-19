package dataStructures.TreesAndGraphs;

import java.util.*;

/*
 * PROBLEM: Number of Connected Components
 * Problem Statement:
 * Given an undirected graph, find the number of connected components.
 * Concepts Tested:
 *  DFS/BFS
 *  Visited array
 */
public class ConnectedComponents {
    private int V;
    private LinkedList<Integer> adj[];

    ConnectedComponents(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;

        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    int countConnectedComponents() {
        boolean visited[] = new boolean[V];
        int count = 0;
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                // If vertex is not visited, it starts a new component
                DFSUtil(v, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        ConnectedComponents g = new ConnectedComponents(5);

        // Component 1: 0-1-2
        g.addEdge(0, 1);
        g.addEdge(1, 2);

        // Component 2: 3-4
        g.addEdge(3, 4);

        System.out.println("Number of connected components: " + g.countConnectedComponents());
    }
}
