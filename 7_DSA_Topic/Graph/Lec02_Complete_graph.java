/*
    ================================
    COMPLETE GRAPH IN JAVA (NOTES)
    ================================

    1. What is a Complete Graph?
        - An undirected graph is called complete if there is an edge between every pair of distinct vertices.
        - In a complete graph with N vertices, each vertex is connected to (N-1) other vertices.
        - The total number of edges in a complete undirected graph is N*(N-1)/2.

        - The total number of edges in a complete directed graph is N*(N-1).

    2. Properties:
        - Degree of each vertex is (N-1).
        - The adjacency matrix of a complete graph has all 1s except the diagonal (which is 0).
        - Used in network design, combinatorics, and theoretical computer science.

    3. How to Check if a Graph is Complete?
        - For every vertex, check if it is connected to all other vertices (excluding itself).
        - In adjacency list: Each list should have (N-1) neighbors.
        - In adjacency matrix: All off-diagonal elements should be 1.

    4. Time Complexity:
        - O(N^2) for adjacency matrix.
        - O(N + E) for adjacency list (if you check all lists).

    5. Example Code (Adjacency List):



IMPORTANT Properties

    1. Number of vertices (V):
        - Let the graph have V vertices.

    2. Number of edges (E):
        - In a complete undirected graph: E = V(V-1)/2  ; 
        - In a complete directed graph (since for each pair we have 2 directed edges): E=V×(V−1)

    3. In-degree and Out-degree:
        For each vertex:
        - In-degree = V-1 (because all other vertices have an edge to it).
        - Out-degree = V-1 (because it has an edge to all other vertices).

        So, Total degree = (V-1) + (V-1) = 2(V-1).

    4. Connectedness:
        - A complete directed graph is strongly connected, because from any vertex you can reach any other vertex directly.

*/

import java.util.ArrayList;
import java.util.List;

class Graph{
    // Function to build adjacency list
    // @SuppressWarnings("unused")
    public ArrayList<Integer>[] buildAdjList(int n, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u); // undirected graph
        }
        return adj;
    }

    public boolean isCompleteGraph(ArrayList<Integer>[] adj){
        int n = adj.length ; 
        List<Integer>component = new ArrayList<>() ; 

        boolean[] visited = new boolean[n] ;

        // we can start we any node to check complete graph ; 
        dfs(0 , adj , visited , component) ; 

        if(component.size() != n){
            return false ; 
        }

        for(int node : component){
            if(adj[node].size() != n-1){
                return false ; 
            }
        }

        return true ; 

        
    }


    public void dfs(int node , ArrayList<Integer>[] adj , boolean[] visited , List<Integer>component){
        visited[node] = true ; 
        component.add(node) ; 

        for(int neighbor : adj[node]){
            if(!visited[neighbor]){
                dfs(neighbor , adj , visited , component) ; 
            }
        }
    }

}


public class Lec02_Complete_graph {
    // Main method for testing
    public static void main(String[] args) {
        Graph graph = new Graph();

        int n = 4; // number of nodes
        int[][] edges = { {0,1}, {0,2}, {0,3}, {1,2}, {1,3}, {2,3} }; // complete graph

        ArrayList<Integer>[] adj = graph.buildAdjList(n, edges) ; 
        System.out.println("Checking graph is complete or not : " + graph.isCompleteGraph(adj)) ; 


    }
}






