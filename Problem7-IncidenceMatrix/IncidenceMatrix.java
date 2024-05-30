import java.util.*;

public class IncidenceMatrix {
    private List<List<Integer>> matrix = new ArrayList<>();
    private Map<Integer, List<Integer>> edgeList = new HashMap<>();
    private int edgeCount = 0;

    IncidenceMatrix(int vertices) {
        for (int i = 0; i < vertices; i++) {
            matrix.add(new ArrayList<>());
        }
    }

    void addEdge(int src, int dest, int times) {
        for (int i = 0; i < times; i++) {
            edgeList.put(edgeCount, Arrays.asList(src, dest));
            for (List<Integer> row : matrix) {
                row.add(0);
            }
            matrix.get(src).set(edgeCount, 1);
            matrix.get(dest).set(edgeCount, 1);
            edgeCount++;
        }
    }

    void printMatrix() {
        for (List<Integer> row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        IncidenceMatrix graph = new IncidenceMatrix(5);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(4, 0, 1);
        graph.printMatrix();
    }
}