import java.util.*;

public class DijkstraAlgorithm {

    // Class to represent a node in the graph
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];

        // Initialize all distances as INFINITE and visited[] as false
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Priority queue to store vertices that are being processed
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            // Extract the vertex with minimum distance value
            int u = pq.poll().vertex;

            // Mark the vertex as visited
            visited[u] = true;

            // Update distance value of all adjacent vertices
            for (int v = 0; v < vertices; v++) {
                // Update distance only if:
                // 1. There's an edge from u to v
                // 2. v is not visited
                // 3. New distance is shorter than current distance
                if (graph[u][v] != 0 && !visited[v] &&
                        distances[u] != Integer.MAX_VALUE &&
                        distances[u] + graph[u][v] < distances[v]) {

                    distances[v] = distances[u] + graph[u][v];
                    pq.add(new Node(v, distances[v]));
                }
            }
        }

        // Print the shortest distances
        printSolution(distances, source);
    }

    private static void printSolution(int[] distances, int source) {
        System.out.println("Vertex \t\t Distance from Source (" + source + ")");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + " \t\t " + distances[i]);
        }
    }

    public static void main(String[] args) {
        // Example graph represented as adjacency matrix
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstra(graph, 0); // Find shortest paths from vertex 0
    }
}