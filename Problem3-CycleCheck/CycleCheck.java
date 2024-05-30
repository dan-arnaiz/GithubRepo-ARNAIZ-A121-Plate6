import java.util.*;

public class CycleCheck {
    private ArrayList<ArrayList<Integer>> adjLists;

    CycleCheck(int vertices) {
        adjLists = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++)
            adjLists.add(new ArrayList<>());
    }

    void addEdge(int src, int dest) {
        adjLists.get(src).add(dest);
        adjLists.get(dest).add(src);
    }

    boolean isCyclicUtil(int v, boolean visited[], int parent) {
        visited[v] = true;
        for (int i : adjLists.get(v)) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }

    boolean isCyclic() {
        boolean visited[] = new boolean[adjLists.size()];
        for (int i = 0; i < adjLists.size(); i++)
            if (!visited[i] && isCyclicUtil(i, visited, -1))
                return true;
        return false;
    }

    public static void main(String args[]) {
        CycleCheck g1 = new CycleCheck(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println("Graph 1 " + (g1.isCyclic() ? "contains a cycle" : "doesn't contain a cycle"));


        CycleCheck g2 = new CycleCheck(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        System.out.println("Graph 2 " + (g2.isCyclic() ? "contains a cycle" : "doesn't contain a cycle"));
    }
}