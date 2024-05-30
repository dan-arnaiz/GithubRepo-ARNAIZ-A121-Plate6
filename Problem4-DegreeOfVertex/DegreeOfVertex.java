import java.util.*;

public class DegreeOfVertex {
    private Map<Integer, List<Integer>> adjLists = new HashMap<>();

    void addEdge(int src, int dest) {
        adjLists.putIfAbsent(src, new ArrayList<>());
        adjLists.putIfAbsent(dest, new ArrayList<>());
        adjLists.get(src).add(dest);
        adjLists.get(dest).add(src);
    }

    int degreeOfVertex(int vertex) {
        return adjLists.get(vertex).size();
    }

    public static void main(String[] args) {
        DegreeOfVertex graph = new DegreeOfVertex();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        for (int i = 0; i < 4; i++) {
            System.out.println("Degree of vertex " + i + " is: " + graph.degreeOfVertex(i));
        }
    }
}