import java.util.Arrays;

public class HamiltonianCycle {
    private int V; // Number of vertices
    private int[] path;
    private int[][] graph;

    public HamiltonianCycle(int[][] graph) {
        this.graph = graph;
        this.V = graph.length;
        this.path = new int[V];
        Arrays.fill(path, -1);
    }

    public void findHamiltonianCycle() {
        // Start with vertex 0 as the first vertex in the path
        path[0] = 0;

        if (!solve(1)) {
            System.out.println("No Hamiltonian Cycle exists");
        }
    }

    private boolean solve(int pos) {
        // Base case: All vertices are included in the path
        if (pos == V) {
            // Check if there's an edge from last vertex to first vertex
            if (graph[path[pos - 1]][path[0]] == 1) {
                printSolution();
                return true;
            }
            return false;
        }

        // Try different vertices as next candidate
        for (int v = 1; v < V; v++) {
            if (isSafe(v, pos)) {
                path[pos] = v;

                if (solve(pos + 1)) {
                    return true;
                }

                // Backtrack: Remove current vertex if it doesn't lead to a solution
                path[pos] = -1;
            }
        }
        return false;
    }

    private boolean isSafe(int v, int pos) {
        // Check if this vertex is adjacent to the previously added vertex
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }

        // Check if the vertex has already been included in the path
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }

        return true;
    }

    private void printSolution() {
        System.out.println("Hamiltonian Cycle exists:");
        for (int i = 0; i < V; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]); // Print the first vertex again to show cycle
    }

    public static void main(String[] args) {
        /* Example graph (adjacency matrix):
            (0)--(1)--(2)
             |   / \   |
             |  /   \  |
             | /     \ |
            (3)-------(4) */
        int[][] graph = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };

        HamiltonianCycle hc = new HamiltonianCycle(graph);
        hc.findHamiltonianCycle();
    }
}