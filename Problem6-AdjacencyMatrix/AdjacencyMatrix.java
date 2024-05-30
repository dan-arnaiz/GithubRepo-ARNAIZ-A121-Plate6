import java.util.*;

public class AdjacencyMatrix {
    private int[][] matrix;

    AdjacencyMatrix(int vertices) {
        matrix = new int[vertices][vertices];
    }

    void addEdge(int src, int dest, boolean isDirected) {
        matrix[src][dest] += 1;
        if (!isDirected) {
            matrix[dest][src] += 1;
        }
    }

    void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix(5);
        graph.addEdge(0, 1, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(3, 4, false);
        graph.addEdge(4, 0, false);
        graph.addEdge(0, 0, false); // loop
        graph.addEdge(1, 2, false); // multiple edge
        graph.addEdge(4, 2, true);  // directed edge
        graph.printMatrix();
    }
}