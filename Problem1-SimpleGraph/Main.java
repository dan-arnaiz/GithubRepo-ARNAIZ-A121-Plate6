import java.util.*;

class Graph {
    private int V;
    private List<List<Integer>> adj;

    Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    int DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        int count = 1;

        for (int i : adj.get(v)) {
            if (!visited[i]) {
                count += DFSUtil(i, visited);
            }
        }
        return count;
    }

    boolean isConnected() {
        boolean[] visited = new boolean[V];
        DFSUtil(0, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    int countComponents() {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                DFSUtil(u, visited);
                count++;
            }
        }
        return count;
    }
}

public class Main {
    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isConnected()) {
            System.out.println("Graph 1 is connected");
        } else {
            System.out.println("Graph 1 is not connected");
            System.out.println("Number of connected components in Graph 1: " + g1.countComponents());
        }

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isConnected()) {
            System.out.println("Graph 2 is connected");
        } else {
            System.out.println("Graph 2 is not connected");
            System.out.println("Number of connected components in Graph 2: " + g2.countComponents());
        }

        Graph g3 = new Graph(4);
        g3.addEdge(0, 1);
        g3.addEdge(2, 3);
        if (g3.isConnected()) {
            System.out.println("Graph 3 is connected");
        } else {
            System.out.println("Graph 3 is not connected");
            System.out.println("Number of connected components in Graph 3: " + g3.countComponents());
        }
    }
}