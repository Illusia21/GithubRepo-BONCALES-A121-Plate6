import java.util.*;

class Graph {
    private int V; // No. of vertices in graph.
    private boolean[][] adj; // Adjacency matrix representation

    boolean[] visited;
    int[][] components;
    int componentCount;

    Graph(int v) {
        V = v;
        adj = new boolean[v][v];
    }

    void addEdge(int u, int w) {
        adj[u][w] = true;
        adj[w][u] = true; // Undirected Graph.
    }

    void DFSUtil(int v) {
        visited[v] = true;
        components[componentCount][v] = 1;
        for (int i = 0; i < V; i++) {
            if (adj[v][i] && !visited[i]) {
                DFSUtil(i);
            }
        }
    }

    boolean isConnected() {
        visited = new boolean[V];
        components = new int[V][V];
        componentCount = 0;

        DFSUtil(0); // Start DFS from node 0

        // If any node remains unvisited, graph is not connected
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    int findConnectedComponents() {
        visited = new boolean[V];
        components = new int[V][V];
        componentCount = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSUtil(i);
                componentCount++;
            }
        }
        return componentCount;
    }
}

