/*
    ================================
    COMPLETE GRAPH IN JAVA (NOTES)
    ================================

    1. What is a Complete Graph?
        - An undirected graph is called complete if there is an edge between every pair of distinct vertices.
        - In a complete graph with N vertices, each vertex is connected to (N-1) other vertices.
        - The total number of edges in a complete undirected graph is N*(N-1)/2.

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

*/

import java.util.*;

public class Lec03_Complete_graph {

    // Graph representation using adjacency list
    static class Graph {
        int V;
        List<List<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        // Function to check if the graph is complete
        boolean isComplete() {
            for (int i = 0; i < V; i++) {
                // Remove self-loops if any
                adj.get(i).removeIf(neighbor -> neighbor == i);
                // Each vertex must be connected to (V-1) other vertices
                Set<Integer> uniqueNeighbors = new HashSet<>(adj.get(i));
                if (uniqueNeighbors.size() != V - 1) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        /*
            Example 1: Complete Graph (3 vertices)
            0---1
             \ /
              2

            Example 2: Not Complete
            0---1
             \
              2
        */

        // Complete graph
        Graph g1 = new Graph(3);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);

        System.out.println("g1 is complete? " + g1.isComplete()); // true

        // Not complete graph
        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);

        System.out.println("g2 is complete? " + g2.isComplete()); // false
    }
}

/*
    6. Notes:
        - For directed graphs, a complete graph means every pair of distinct vertices has edges in both directions.
        - In practice, complete graphs are rare for large N due to the number of edges.
        - You can also use adjacency matrix for easier checking in dense graphs.

    7. Interview Tips:
        - Be careful with self-loops and duplicate edges.
        - For large graphs, adjacency list is more space-efficient.

    ================================
    END OF NOTES
    ================================
*/
