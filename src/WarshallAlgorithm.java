public class WarshallAlgorithm {

    // Function to compute the transitive closure of a graph
    public static void transitiveClosure(int[][] graph, int vertices) {
        int[][] tc = new int[vertices][vertices];

        // Initialize tc[][] with the given graph
        for (int i = 0; i < vertices; i++) {
            System.arraycopy(graph[i], 0, tc[i], 0, vertices);
        }

        // Warshall's Algorithm
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    // If i can reach j via k, set tc[i][j] = 1
                    if (tc[i][j] == 0) {
                        tc[i][j] = (tc[i][k] != 0 && tc[k][j] != 0) ? 1 : 0;
                    }
                }
            }
        }

        // Print the transitive closure matrix
        System.out.println("Transitive Closure Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(tc[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example graph (adjacency matrix)
        int[][] graph = {
                {1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };

        int vertices = graph.length;
        transitiveClosure(graph, vertices);
    }
}