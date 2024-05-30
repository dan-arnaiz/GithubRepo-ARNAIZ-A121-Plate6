import java.util.*;

public class IsomorphicCheck {
    public static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        if (graph1.length != graph2.length) {
            return false;
        }

        int[] degreeSequence1 = new int[graph1.length];
        int[] degreeSequence2 = new int[graph2.length];

        for (int i = 0; i < graph1.length; i++) {
            for (int j = 0; j < graph1[i].length; j++) {
                degreeSequence1[i] += graph1[i][j];
                degreeSequence2[i] += graph2[i][j];
            }
        }

        Arrays.sort(degreeSequence1);
        Arrays.sort(degreeSequence2);

        return Arrays.equals(degreeSequence1, degreeSequence2);
    }

    public static void main(String[] args) {
        int[][] graph1 = {
            {0, 1, 1, 0},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {0, 0, 1, 0}
        };

        int[][] graph2 = {
            {0, 1, 0, 1},
            {1, 0, 1, 1},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };

        System.out.println(areIsomorphic(graph1, graph2) ? "The graphs are isomorphic" : "The graphs are not isomorphic");
    }
}