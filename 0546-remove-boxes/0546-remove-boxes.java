class Solution {
    private int[][][] dp;
    private int[] boxes;
    
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        this.boxes = boxes;
        dp = new int[n][n][n];
        return dfs(0, n - 1, 0);
    }
    
    private int dfs(int l, int r, int k) {
        if (l > r) return 0;
        if (dp[l][r][k] != 0) return dp[l][r][k];
        
        // Merge same-colored boxes at the left
        int origL = l, origK = k;
        while (l + 1 <= r && boxes[l + 1] == boxes[l]) {
            l++;
            k++;
        }
        
        // Option 1: remove current group directly
        int res = (k + 1) * (k + 1) + dfs(l + 1, r, 0);
        
        // Option 2: try to merge with same color later
        for (int m = l + 1; m <= r; m++) {
            if (boxes[m] == boxes[l]) {
                res = Math.max(res,
                               dfs(l + 1, m - 1, 0) + dfs(m, r, k + 1));
            }
        }
        
        dp[origL][r][origK] = res;
        return res;
    }
}
