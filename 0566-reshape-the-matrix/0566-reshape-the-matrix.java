class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        
        if (m * n != r * c) return mat; // reshape not possible
        
        int[][] res = new int[r][c];
        
        for (int i = 0; i < m * n; i++) {
            res[i / c][i % c] = mat[i / n][i % n];
        }
        
        return res;
    }
}
