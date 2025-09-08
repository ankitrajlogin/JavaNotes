/*
Graph Traversals in Java (BFS & DFS in separate classes)
    🔹 Time Complexity: O(V + E)
    🔹 Space Complexity: O(V)
*/

import java.util.*;

// ------------------ Graph Class ------------------
class Graph {
    int V;                     // number of vertices
    boolean isDirected;        // directed or undirected
    List<List<Integer>> adj;   // adjacency list

    // Constructor
    Graph(int V, boolean isDirected) {
        this.V = V;
        this.isDirected = isDirected;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add edge
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        if (!isDirected) {
            adj.get(v).add(u);
        }
    }

    // Print adjacency list
    void printGraph() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

// ------------------ BFS Class ------------------
class BFS {
    void traverse(Graph g, int start) {
        boolean[] visited = new boolean[g.V];
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("BFS Traversal starting from " + start + ":");

        // Traverse all components (for disconnected graph)
        for (int s = start; s < g.V; s++) {
            if (!visited[s]) {
                visited[s] = true;
                queue.add(s);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    System.out.print(node + " ");

                    for (int neighbor : g.adj.get(node)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
        System.out.println("\n");
    }
}

// ------------------ DFS Class ------------------
class DFS {
    void traverse(Graph g, int start) {
        boolean[] visited = new boolean[g.V];
        System.out.println("DFS Traversal starting from " + start + ":");

        // Traverse all components (for disconnected graph)
        for (int node = start; node < g.V; node++) {
            if (!visited[node]) {
                dfsUtil(g, node, visited);
            }
        }
        System.out.println("\n");
    }

    private void dfsUtil(Graph g, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : g.adj.get(node)) {
            if (!visited[neighbor]) {
                dfsUtil(g, neighbor, visited);
            }
        }
    }
}

// ------------------ Main Class ------------------
public class Lec06_BFS_DFS {
    public static void main(String[] args) {
        int V = 6;
        boolean isDirected = false;  // change to true if directed graph
        Graph g = new Graph(V, isDirected);

        // Example edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        // Print graph
        g.printGraph();

        // BFS
        BFS bfs = new BFS();
        bfs.traverse(g, 0);

        // DFS
        DFS dfs = new DFS();
        dfs.traverse(g, 0);
    }
}
