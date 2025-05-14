public class SubsetSum {

    public static boolean isSubsetSum(int[] set, int sum) {
        int n = set.length;
        // dp[i][j] will be true if a subset of set[0..i-1] has sum equal to j
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base case: sum 0 can always be achieved with empty subset
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (set[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        if (isSubsetSum(set, sum)) {
            System.out.println("Found a subset with given sum");
        } else {
            System.out.println("No subset with given sum");
        }
    }
}