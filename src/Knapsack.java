public class Knapsack {

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapsack(int W, int[] weights, int[] values, int n) {
        // Create a 2D array to store the maximum value at each weight
        int[][] dp = new int[n + 1][W + 1];

        // Build the dp table from the bottom up
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case: 0 items or 0 capacity
                }
                else if (weights[i - 1] <= w) {
                    // Choose between including or excluding the current item
                    dp[i][w] = Math.max(
                            values[i - 1] + dp[i - 1][w - weights[i - 1]], // Include item
                            dp[i - 1][w] // Exclude item
                    );
                }
                else {
                    // Current item's weight exceeds remaining capacity
                    dp[i][w] = dp[i - 1][w]; // Carry forward previous value
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120}; // Values of items
        int[] weights = {10, 20, 30};  // Weights of items
        int W = 50;                    // Knapsack capacity
        int n = values.length;         // Number of items

        int maxValue = knapsack(W, weights, values, n);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}