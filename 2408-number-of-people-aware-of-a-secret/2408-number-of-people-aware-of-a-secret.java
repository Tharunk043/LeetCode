class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1; // Day 1, one person knows

        for (int day = 1; day <= n; day++) {
            for (int share = day + delay; share < day + forget && share <= n; share++) {
                dp[share] = (dp[share] + dp[day]) % MOD;
            }
        }

        // Sum of people who still remember the secret on day n
        long ans = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) ans = (ans + dp[day]) % MOD;
        }

        return (int) ans;
    }
}
