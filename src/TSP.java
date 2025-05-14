import java.util.Arrays;

public class TSP {

    private static final int INF = Integer.MAX_VALUE;

    public static int tsp(int[][] graph) {
        int n = graph.length;
        int[][] memo = new int[n][1 << n];

        // Initialize memo table with -1 (uncomputed)
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Start from city 0, with mask 000...01 (only city 0 visited)
        return tspHelper(graph, 0, 1, memo);
    }

    private static int tspHelper(int[][] graph, int current, int mask, int[][] memo) {
        // All cities visited, return to start (city 0)
        if (mask == (1 << graph.length) - 1) {
            return graph[current][0];
        }

        // Return memoized result if available
        if (memo[current][mask] != -1) {
            return memo[current][mask];
        }

        int minCost = INF;

        // Try all unvisited cities
        for (int next = 0; next < graph.length; next++) {
            if ((mask & (1 << next)) == 0) { // If city 'next' not visited
                int newMask = mask | (1 << next);
                int cost = graph[current][next] + tspHelper(graph, next, newMask, memo);
                minCost = Math.min(minCost, cost);
            }
        }

        // Memoize and return the result
        return memo[current][mask] = minCost;
    }

    public static void main(String[] args) {
        // Example graph (distance matrix)
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        int minCost = tsp(graph);
        System.out.println("Minimum cost for TSP: " + minCost);
    }
}