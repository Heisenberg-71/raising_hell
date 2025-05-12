package link_State_shortest_path;

import java.util.*;

public class LinkStateRouting {

    static final int INF = 9999;  // Representation of Infinity
    static int V; // Number of vertices (routers)

    // Find vertex with minimum distance
    int minDistance(int[] dist, Boolean[] visited) {
        int min = INF, min_index = -1;
        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    // Dijkstra's Algorithm
    void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V]; // Shortest distance from src to i
        Boolean[] visited = new Boolean[V]; // Visited vertices

        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print shortest paths from source
        System.out.println("Node \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkStateRouting lsr = new LinkStateRouting();

        System.out.print("Enter number of routers (nodes): ");
        V = sc.nextInt();

        int[][] graph = new int[V][V];
        System.out.println("Enter adjacency matrix (0 if no link, weight otherwise):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source router index (0 to " + (V - 1) + "): ");
        int src = sc.nextInt();

        lsr.dijkstra(graph, src);
    }
}
