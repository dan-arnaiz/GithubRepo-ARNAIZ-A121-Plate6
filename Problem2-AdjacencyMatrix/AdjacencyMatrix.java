import java.util.*;

class AdjacencyMatrix {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
            {0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };

        Map<String, Integer> edgeCount = new HashMap<>();

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = i + 1; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    String edge = i + "-" + j;
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println("Edge " + entry.getKey() + " appears " + entry.getValue() + " times");
        }
    }
}