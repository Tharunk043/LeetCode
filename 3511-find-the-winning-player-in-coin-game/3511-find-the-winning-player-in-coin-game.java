class Solution {
    public String winningPlayer(int x, int y) {
        int k = Math.min(x, y / 4);
        return (k % 2 == 1) ? "Alice" : "Bob";
    }
}
