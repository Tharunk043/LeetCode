class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                if (xi <= xj && yi >= yj && (xi < xj || yi > yj)) {
                    boolean valid = true;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int xk = points[k][0], yk = points[k][1];
                        if (xk >= xi && xk <= xj && yk >= yj && yk <= yi) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}