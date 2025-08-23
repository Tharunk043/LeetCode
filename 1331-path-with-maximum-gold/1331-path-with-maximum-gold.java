class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxGold = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        
        return maxGold;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        
        // Boundary check + no gold cell
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;
        
        int gold = grid[i][j];
        grid[i][j] = 0; // mark visited
        
        int max = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            max = Math.max(max, dfs(grid, ni, nj));
        }
        
        grid[i][j] = gold; // backtrack
        return gold + max;
    }
}
