class Solution {
    public double soupServings(int n) {
        if (n >= 5000) {
            // As the value of n increases, the probability approaches 1.
            // To avoid stack overflow for large values of n, we return 1 directly.
            return 1.0;
        }

        int m = (int) Math.ceil(n / 25.0);
        double[][] dp = new double[m + 1][m + 1];
        dp[0][0] = 0.5; // Base case: probability of serving 0 from both dishes is 0.5.

        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0; // Probability of serving from the first dish is 0 if the second dish is empty.
            dp[0][i] = 1; // Probability of serving from the second dish is 1 if the first dish is empty.
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = 0.25 * (dp[Math.max(i - 4, 0)][j] + dp[Math.max(i - 3, 0)][Math.max(j - 1, 0)]
                        + dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)] + dp[Math.max(i - 1, 0)][Math.max(j - 3, 0)]);
            }
        }

        return dp[m][m];
    }
}