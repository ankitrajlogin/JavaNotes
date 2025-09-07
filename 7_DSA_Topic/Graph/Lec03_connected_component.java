/*
    ================================
    CONNECTED COMPONENTS IN JAVA GRAPH
    ================================

    1. What is a Connected Component?
        - In an undirected graph, a connected component is a maximal set of vertices such that each pair of vertices is connected by a path.
        - In other words, every node in a connected component can reach every other node in that component.
        - A graph can have one or more connected components.

    2. Why is it Important?
        - Identifying connected components helps in understanding the structure of a graph.
        - Useful in clustering, network analysis, image processing, etc.

    3. How to Find Connected Components?
        - Use Depth First Search (DFS) or Breadth First Search (BFS).
        - For each unvisited node, start a DFS/BFS and mark all reachable nodes as visited.
        - Each DFS/BFS traversal identifies one connected component.

    4. Time Complexity:
        - O(V + E), where V is the number of vertices and E is the number of edges.

    5. Example Code (Using DFS):

*/

import java.util.*;

// Graph representation using adjacency list
class Graph {
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

    // DFS utility to mark all reachable vertices from v
    void dfs(int v, boolean[] visited, List<Integer> component) {
        visited[v] = true;
        component.add(v);
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, component);
            }
        }
    }

    // Function to find all connected components
    List<List<Integer>> getConnectedComponents() {
        boolean[] visited = new boolean[V];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, visited, component);
                components.add(component);
            }
        }
        return components;
    }
}


public class Lec03_connected_component {
    public static void main(String[] args) {
        /*
            Example:
            0---1     3
            |   |     |
            2   4     5

            There are 2 connected components: {0,1,2,4} and {3,5}
        */
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 4);
        g.addEdge(3, 5);

        List<List<Integer>> components = g.getConnectedComponents();
        System.out.println("Number of connected components: " + components.size());
        int idx = 1;
        for (List<Integer> comp : components) {
            System.out.println("Component " + idx++ + ": " + comp);
        }
    }
}

/*
    6. Notes:
        - For directed graphs, use Kosaraju's or Tarjan's algorithm for strongly connected components.
        - For weighted graphs, the approach is the same for finding connected components.
        - You can use BFS instead of DFS for the same purpose.

    7. Interview Tips:
        - Always mark nodes as visited to avoid infinite loops.
        - Connected components are useful for checking if a graph is fully connected (only one component).
        - Practice both iterative and recursive DFS/BFS approaches.

    ================================
    END OF NOTES
    ================================
*/
