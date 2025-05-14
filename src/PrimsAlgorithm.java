import java.util.*;

public class PrimsAlgorithm {

    static class Edge {
        int dest;
        int weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void primMST(List<List<Edge>> graph, int vertices) {
        boolean[] inMST = new boolean[vertices];
        int[] parent = new int[vertices];
        int[] key = new int[vertices];

        // Initialize keys to infinity
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; // Start from vertex 0
        parent[0] = -1; // Root has no parent

        // Priority queue to pick the minimum key vertex
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            inMST[u] = true;

            for (Edge edge : graph.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                if (!inMST[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                    pq.offer(new int[]{v, key[v]});
                }
            }
        }

        printMST(parent, graph, vertices);
    }

    private static void printMST(int[] parent, List<List<Edge>> graph, int vertices) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + getWeight(parent[i], i, graph));
        }
    }

    private static int getWeight(int u, int v, List<List<Edge>> graph) {
        for (Edge edge : graph.get(u)) {
            if (edge.dest == v) {
                return edge.weight;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int vertices = 5;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges (undirected graph)
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(3, 6));
        graph.get(1).add(new Edge(0, 2));
        graph.get(1).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 8));
        graph.get(1).add(new Edge(4, 5));
        graph.get(2).add(new Edge(1, 3));
        graph.get(2).add(new Edge(4, 7));
        graph.get(3).add(new Edge(0, 6));
        graph.get(3).add(new Edge(1, 8));
        graph.get(4).add(new Edge(1, 5));
        graph.get(4).add(new Edge(2, 7));

        primMST(graph, vertices);
    }
}