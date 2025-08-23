class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        // Try 4 rotations (0°, 90°, 180°, 270°)
        for (int r = 0; r < 4; r++) {
            if (isEqual(mat, target)) {
                return true;
            }
            mat = rotate(mat); // rotate 90° clockwise
        }

        return false;
    }

    // Check if two matrices are equal
    private boolean isEqual(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Rotate matrix 90° clockwise
    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = mat[i][j];
            }
        }
        return rotated;
    }
}
