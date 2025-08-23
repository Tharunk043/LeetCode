class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[] onesRow = new int[m];
        int[] onesCol = new int[n];
        
        // count ones in each row and col
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    onesRow[i]++;
                    onesCol[j]++;
                }
            }
        }
        
        int[][] diff = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int zerosRow = n - onesRow[i];
                int zerosCol = m - onesCol[j];
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow - zerosCol;
            }
        }
        
        return diff;
    }
}
