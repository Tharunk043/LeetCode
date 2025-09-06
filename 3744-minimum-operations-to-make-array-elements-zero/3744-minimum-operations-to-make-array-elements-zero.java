class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            ans += (g(r) - g(l - 1) + 1) / 2;
        }
        return ans;
    }

    private long g(int n) {
        long res = 0;
        int ops = 0;
        for (long power = 1; power <= n; power *= 4) {
            ops++;
            long l = power;
            long r = Math.min(n, power * 4 - 1);
            res += (r - l + 1) * ops;
        }
        return res;
    }
}
