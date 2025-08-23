class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        long totalAvailable = 1L * n * n;           // n stacks × n containers each
        long maxByWeight   = (long) maxWeight / w;  // how many containers fit by weight
        return (int) Math.min(totalAvailable, maxByWeight);
    }
}
