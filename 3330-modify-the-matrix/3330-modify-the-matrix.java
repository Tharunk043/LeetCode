class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Step 1: Find maximum value for each column
        int[] colMax = new int[n];
        for (int j = 0; j < n; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            colMax[j] = max;
        }
        
        // Step 2: Replace all -1 values with column maximum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = colMax[j];
                }
            }
        }
        
        return matrix;
    }
}