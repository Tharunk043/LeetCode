class Solution {
    public long flowerGame(int n, int m) {
        // Count of odd and even numbers in [1, n] and [1, m]
        long oddN = (n + 1L) / 2;
        long evenN = n / 2L;
        long oddM = (m + 1L) / 2;
        long evenM = m / 2L;

        // Total valid pairs where Alice wins
        return oddN * evenM + evenN * oddM;
    }
}