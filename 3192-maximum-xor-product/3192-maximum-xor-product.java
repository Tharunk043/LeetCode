class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        final long MOD = 1_000_000_007;
        if (n > 0) {
            for (long bit = 1L << (n - 1); bit > 0; bit >>= 1) {
                // Only flip if the minimum of (a, b) has this bit == 0
                if ((Math.min(a, b) & bit) == 0) {
                    a ^= bit;
                    b ^= bit;
                }
            }
        }
        return (int)((a % MOD) * (b % MOD) % MOD);
    }
}
