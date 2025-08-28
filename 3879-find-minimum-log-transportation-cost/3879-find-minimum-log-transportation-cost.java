class Solution {
    public long minCuttingCost(long n, long m, int k) {
        long x = Math.max(n, m);
        if (x <= k) {
            return 0;
        }
        return (long) k * (x - k);
    }
}
