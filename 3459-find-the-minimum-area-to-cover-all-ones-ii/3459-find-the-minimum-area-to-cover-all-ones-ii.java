class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int INF = 1_000_000_000;
        
        // precompute prefix sum to get fast counts
        int[][] pref = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pref[i + 1][j + 1] = pref[i + 1][j] + pref[i][j + 1] - pref[i][j] + grid[i][j];
            }
        }
        
        // helper: sum of submatrix (inclusive)
        java.util.function.BiFunction<int[], int[], Integer> sum = (a, b) -> {
            int r1 = a[0], c1 = a[1], r2 = b[0], c2 = b[1];
            return pref[r2 + 1][c2 + 1] - pref[r1][c2 + 1] - pref[r2 + 1][c1] + pref[r1][c1];
        };
        
        // compute min area of covering rectangle for submatrix band
        // cover all 1s in [r1..r2]x[c1..c2]
        java.util.function.BiFunction<int[], int[], Integer> rectArea = (a, b) -> {
            int r1 = a[0], c1 = a[1], r2 = b[0], c2 = b[1];
            int minR = m, maxR = -1, minC = n, maxC = -1;
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    if (grid[i][j] == 1) {
                        if (i < minR) minR = i;
                        if (i > maxR) maxR = i;
                        if (j < minC) minC = j;
                        if (j > maxC) maxC = j;
                    }
                }
            }
            if (maxR == -1) return 0; // no 1s
            return (maxR - minR + 1) * (maxC - minC + 1);
        };

        int ans = INF;

        // --- 3 vertical stripes ---
        for (int c1 = 0; c1 < n - 2; c1++) {
            for (int c2 = c1 + 1; c2 < n - 1; c2++) {
                int a1 = rectArea.apply(new int[]{0,0}, new int[]{m-1,c1});
                int a2 = rectArea.apply(new int[]{0,c1+1}, new int[]{m-1,c2});
                int a3 = rectArea.apply(new int[]{0,c2+1}, new int[]{m-1,n-1});
                if (a1 > 0 && a2 > 0 && a3 > 0)
                    ans = Math.min(ans, a1 + a2 + a3);
            }
        }

        // --- 3 horizontal stripes ---
        for (int r1 = 0; r1 < m - 2; r1++) {
            for (int r2 = r1 + 1; r2 < m - 1; r2++) {
                int a1 = rectArea.apply(new int[]{0,0}, new int[]{r1,n-1});
                int a2 = rectArea.apply(new int[]{r1+1,0}, new int[]{r2,n-1});
                int a3 = rectArea.apply(new int[]{r2+1,0}, new int[]{m-1,n-1});
                if (a1 > 0 && a2 > 0 && a3 > 0)
                    ans = Math.min(ans, a1 + a2 + a3);
            }
        }

        // --- 1 vertical + 2 horizontal ---
        for (int c = 0; c < n - 1; c++) {
            for (int r = 0; r < m - 1; r++) {
                int left = rectArea.apply(new int[]{0,0}, new int[]{m-1,c});
                int topRight = rectArea.apply(new int[]{0,c+1}, new int[]{r,n-1});
                int botRight = rectArea.apply(new int[]{r+1,c+1}, new int[]{m-1,n-1});
                if (left > 0 && topRight > 0 && botRight > 0)
                    ans = Math.min(ans, left + topRight + botRight);
                
                int right = rectArea.apply(new int[]{0,c+1}, new int[]{m-1,n-1});
                int topLeft = rectArea.apply(new int[]{0,0}, new int[]{r,c});
                int botLeft = rectArea.apply(new int[]{r+1,0}, new int[]{m-1,c});
                if (right > 0 && topLeft > 0 && botLeft > 0)
                    ans = Math.min(ans, right + topLeft + botLeft);
            }
        }

        // --- 1 horizontal + 2 vertical ---
        for (int r = 0; r < m - 1; r++) {
            for (int c = 0; c < n - 1; c++) {
                int top = rectArea.apply(new int[]{0,0}, new int[]{r,n-1});
                int leftBot = rectArea.apply(new int[]{r+1,0}, new int[]{m-1,c});
                int rightBot = rectArea.apply(new int[]{r+1,c+1}, new int[]{m-1,n-1});
                if (top > 0 && leftBot > 0 && rightBot > 0)
                    ans = Math.min(ans, top + leftBot + rightBot);

                int bot = rectArea.apply(new int[]{r+1,0}, new int[]{m-1,n-1});
                int leftTop = rectArea.apply(new int[]{0,0}, new int[]{r,c});
                int rightTop = rectArea.apply(new int[]{0,c+1}, new int[]{r,n-1});
                if (bot > 0 && leftTop > 0 && rightTop > 0)
                    ans = Math.min(ans, bot + leftTop + rightTop);
            }
        }

        return ans;
    }
}
