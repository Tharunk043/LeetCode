class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        // Try possible values of k (up to 60 is enough because num1 is bounded by 10^9)
        for (int k = 1; k <= 60; k++) {
            long diff = (long)num1 - (long)k * num2;
            if (diff < k) continue; // condition not satisfied
            int bits = Long.bitCount(diff);
            if (bits <= k && k <= diff) {
                return k;
            }
        }
        return -1;
    }
}
