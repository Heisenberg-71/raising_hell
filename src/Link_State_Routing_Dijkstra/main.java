package Link_State_Routing_Dijkstra;

import java.util.*;

public class main {
    static final int INF = 999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of routers: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter cost matrix (999 for no direct link):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int src = 0; src < n; src++) {
            dijkstra(graph, n, src);
        }
    }

    public static void dijkstra(int[][] graph, int n, int src) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int[] prev = new int[n];

        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);

        dist[src] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = minDistance(dist, visited, n);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    prev[v] = u;
                }
            }
        }

        // Print routing table
        System.out.println("\nRouting Table for Router " + src + ":");
        System.out.println("Destination\tCost\t\tNext Hop");
        for (int i = 0; i < n; i++) {
            if (i != src) {
                int nextHop = getNextHop(src, i, prev);
                System.out.println("     " + i + "\t\t" + dist[i] + "\t\t   " + nextHop);
            }
        }
    }

    public static int minDistance(int[] dist, boolean[] visited, int n) {
        int min = INF, min_index = -1;
        for (int v = 0; v < n; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    public static int getNextHop(int src, int dest, int[] prev) {
        int hop = dest;
        while (prev[hop] != src && prev[hop] != -1) {
            hop = prev[hop];
        }
        return hop == -1 ? "-" : hop;
    }
}
