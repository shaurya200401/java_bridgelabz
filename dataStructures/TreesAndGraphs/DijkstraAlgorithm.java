package dataStructures.TreesAndGraphs;

import java.util.*;

/*
 * PROBLEM: Shortest Path in Weighted Graph (Dijkstra’s Algorithm)
 * Problem Statement:
 * Given a weighted graph and a source node, find the shortest distance from the source to all other
 * nodes.
 * Constraints:
 *  Graph may contain cycles
 *  All edge weights are positive
 * Concepts Tested:
 *  Priority Queue
 *  Greedy algorithms
 *  Graph optimization
 */
public class DijkstraAlgorithm {

    // Inner class to represent a node and its distance (for PriorityQueue)
    static class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node() {
        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.cost < node2.cost)
                return -1;
            if (node1.cost > node2.cost)
                return 1;
            return 0;
        }
    }

    private int V;
    private List<List<Node>> adj;

    public DijkstraAlgorithm(int V) {
        this.V = V;
        adj = new ArrayList<List<Node>>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Node>());
        }
    }

    public void addEdge(int u, int v, int w) {
        adj.get(u).add(new Node(v, w));
        adj.get(v).add(new Node(u, w)); // Assuming undirected for this example
    }

    public void dijkstra(int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[src] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(V, new Node());
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().node;

            for (Node v : adj.get(u)) {
                if (dist[v.node] > dist[u] + v.cost) {
                    dist[v.node] = dist[u] + v.cost;
                    pq.add(new Node(v.node, dist[v.node]));
                }
            }
        }

        // Print results
        System.out.println("Vertex \t\t Shortest Distance from Source " + src);
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String args[]) {
        int V = 5;
        DijkstraAlgorithm g = new DijkstraAlgorithm(V);

        // 0-1 (9), 0-2 (6), 0-3 (5), 0-4 (3)
        // Others...
        g.addEdge(0, 1, 9);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(0, 4, 3);

        g.addEdge(2, 1, 2);
        g.addEdge(2, 3, 4);

        g.dijkstra(0);
    }
}
