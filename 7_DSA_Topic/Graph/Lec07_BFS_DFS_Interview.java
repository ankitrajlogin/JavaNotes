
/*
BFS & DFS in Java (using ArrayList<Integer>[] adjacency list)
    🔹 Time Complexity: O(V + E)
    🔹 Space Complexity: O(V)
*/

import java.util.*;

class BFS {
    static void traverse(ArrayList<Integer>[] adj, int V, int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("BFS Traversal starting from " + start + ":");

        // Handles disconnected graphs
        for (int s = start; s < V; s++) {
            if (!visited[s]) {
                visited[s] = true;
                queue.add(s);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    System.out.print(node + " ");

                    for (int neighbor : adj[node]) {
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

class DFS {
    static void traverse(ArrayList<Integer>[] adj, int V, int start) {
        boolean[] visited = new boolean[V];
        System.out.println("DFS Traversal starting from " + start + ":");

        for (int s = start; s < V; s++) {
            if (!visited[s]) {
                dfsUtil(adj, s, visited);
            }
        }
        System.out.println("\n");
    }

    private static void dfsUtil(ArrayList<Integer>[] adj, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfsUtil(adj, neighbor, visited);
            }
        }
    }
}

public class Lec07_BFS_DFS_Interview {
    public static void main(String[] args) {
        int V = 6;
        boolean isDirected = false;

        // Create adjacency list
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Add edges
        addEdge(adj, 0, 1, isDirected);
        addEdge(adj, 0, 2, isDirected);
        addEdge(adj, 1, 3, isDirected);
        addEdge(adj, 1, 4, isDirected);
        addEdge(adj, 2, 4, isDirected);
        addEdge(adj, 3, 5, isDirected);
        addEdge(adj, 4, 5, isDirected);

        // Print adjacency list
        printGraph(adj, V);

        // Run traversals
        BFS.traverse(adj, V, 0);
        DFS.traverse(adj, V, 0);
    }

    // Helper to add edge
    private static void addEdge(ArrayList<Integer>[] adj, int u, int v, boolean isDirected) {
        adj[u].add(v);
        if (!isDirected) {
            adj[v].add(u);
        }
    }

    // Print adjacency list
    private static void printGraph(ArrayList<Integer>[] adj, int V) {
        System.out.println("Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adj[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

