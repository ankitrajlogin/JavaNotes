/*

BFS in Java
    🔹 Time Complexity
        - O(V + E) → Each vertex is visited once, each edge is checked once.
    
    🔹 Space Complexity
        - O(V) → For the queue + visited array.

*/

import java.util.LinkedList;
import java.util.Queue; 

class Graph{
    private int V ;   // number of vertices ; 
    private LinkedList<Integer>[] adj ;   // adjacency list 


    // constructor 
    // @SuppressWarnings("unchecked")
    Graph(int V){
        this.V = V ; 
        adj = new LinkedList[V];  // recommended way
        for(int i = 0 ; i< V ; i++){
            adj[i] = new LinkedList<>() ; 
        }
    }


    // add edge (for directed graph)  
    void addEdge(int v , int w){
        adj[v].add(w) ; 
        // for undirected graph , also add : adj[W].add(v) ; 

    }

    void BFS(int start){
        boolean[] visited = new boolean[V] ; 
        Queue<Integer> queue = new LinkedList<>() ; 

        visited[start] = true ; // mark starting node as visited ; 
        queue.add(start) ; 

        System.out.println("BFS traversal starting from vertex " + start + ":");


        while(!queue.isEmpty()){
            int node = queue.poll() ; // dequeue 
            System.out.println(node + " ") ; 

            // Enqueue all unvisited adjacent vertices 
            for(int neighbor : adj[node]){
                if(!visited[neighbor]){
                    visited[neighbor] = true ; 
                    queue.add(neighbor) ; 
                }
            }
        }
        System.out.println();
    }

    // Optional: Print adjacency list
    void printGraph() {
        System.out.println("Graph adjacency list:");
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


public class Lec06_BFS_DFS {
    public static void main(String[] args) {
        int V = 6;  // number of vertices
        Graph g = new Graph(V);

        // Add edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        // Print adjacency list
        g.printGraph();

        // BFS starting from vertex 0
        g.BFS(0);
    }
    
}



/*
NOTE : 
    - LinkedList<Integer>[] listArr = new LinkedList[5]; // array of linked lists


*/