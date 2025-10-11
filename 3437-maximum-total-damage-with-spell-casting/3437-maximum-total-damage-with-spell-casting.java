import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0L) + 1);
        }

        List<Integer> unique = new ArrayList<>(freq.keySet());
        Collections.sort(unique);

        int n = unique.size();
        long[] dp = new long[n];
        dp[0] = (long) unique.get(0) * freq.get(unique.get(0));

        for (int i = 1; i < n; i++) {
            long damage = (long) unique.get(i) * freq.get(unique.get(i));
            int j = i - 1;
            while (j >= 0 && unique.get(j) >= unique.get(i) - 2) {
                j--;
            }
            long include = damage + (j >= 0 ? dp[j] : 0);
            dp[i] = Math.max(dp[i - 1], include);
        }

        return dp[n - 1];
    }
}
