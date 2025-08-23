class Solution {
    public int deleteString(String s) {
        int n = s.length();
        int[][] lcp = new int[n + 1][n + 1];

        // build LCP table (bottom-up)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                }
            }
        }

        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1; // at least delete the whole suffix once
            for (int len = 1; i + len <= n; len++) {
                if (lcp[i][i + len] >= len) {
                    dp[i] = Math.max(dp[i], 1 + dp[i + len]);
                }
            }
        }

        return dp[0];
    }
}
