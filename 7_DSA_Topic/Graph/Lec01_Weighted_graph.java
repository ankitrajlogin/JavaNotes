
/*

Weighted Graph – Definition
    A weighted graph is a graph in which each edge has a weight (or cost) associated with it.

    The weight usually represents:
        - Distance between two nodes (like cities)
        - Cost or time
        - Capacity or any measure depending on the problem

 */

import java.util.ArrayList;

class Pair{
    int vertex ; 
    int weight ; 

    Pair(int vertex , int weight){
        this.vertex = vertex ; 
        this.weight = weight ; 
    }
}

class WeightedGraph{
    int V ; 
    ArrayList<ArrayList<Pair>> adjList ; 

    public WeightedGraph(int V){
        this.V = V ; 
        adjList = new ArrayList<>() ; 

        for(int i = 0 ; i< V ; i++){
            adjList.add(new ArrayList<>()) ; 
        }
    }

    // Method to add edge
    public void addEdge(int u, int v, int weight, boolean directed) {
        adjList.get(u).add(new Pair(v, weight));
        if (!directed) {
            adjList.get(v).add(new Pair(u, weight)); // For undirected graph
        }
    }

    // Method to print the graph
    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (Pair neighbor : adjList.get(i)) {
                System.out.print("(" + neighbor.vertex + ", weight=" + neighbor.weight + ") ");
            }
            System.out.println();
        }
    }

}


public class Lec01_Weighted_graph {
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        WeightedGraph graph = new WeightedGraph(V);

        // Adding edges (undirected graph example)
        graph.addEdge(0, 1, 5, false); // Edge A-B with weight 5
        graph.addEdge(0, 2, 3, false); // Edge A-C with weight 3
        graph.addEdge(1, 3, 2, false); // Edge B-D with weight 2
        graph.addEdge(2, 3, 4, false); // Edge C-D with weight 4

        // Print the graph
        graph.printGraph();
    }
    
}
