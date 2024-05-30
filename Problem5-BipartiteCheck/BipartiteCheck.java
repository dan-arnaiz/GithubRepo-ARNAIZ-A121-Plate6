import java.util.*;

public class BipartiteCheck {
    private Map<Integer, List<Integer>> adjLists = new HashMap<>();

    void addEdge(int src, int dest) {
        adjLists.putIfAbsent(src, new ArrayList<>());
        adjLists.putIfAbsent(dest, new ArrayList<>());
        adjLists.get(src).add(dest);
        adjLists.get(dest).add(src);
    }

    boolean isBipartite(int src) {
        int[] colors = new int[adjLists.size()];
        Arrays.fill(colors, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        colors[src] = 1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adjLists.get(u)) {
                if (colors[v] == -1) {
                    colors[v] = 1 - colors[u];
                    queue.add(v);
                } else if (colors[v] == colors[u]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        BipartiteCheck graph1 = new BipartiteCheck();
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);
        System.out.println(graph1.isBipartite(0) ? "Graph 1 is bipartite" : "Graph 1 is not bipartite");
    
        BipartiteCheck graph2 = new BipartiteCheck();
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 0);
        System.out.println(graph2.isBipartite(0) ? "Graph 2 is bipartite" : "Graph 2 is not bipartite");
    }
}