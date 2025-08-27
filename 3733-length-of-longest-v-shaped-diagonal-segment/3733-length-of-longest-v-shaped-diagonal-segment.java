public class Solution {
    private static final int[][] DIRS = { { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Memoization DP table: [row][col][turned? 0/1][num index (1→2 or 2→0)][direction index]
        Integer[][][][][] memo = new Integer[m][n][2][2][4];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int dx = DIRS[d][0], dy = DIRS[d][1];
                        ans = Math.max(ans, 1 + dfs(grid, i + dx, j + dy, false, 2, d, memo));
                    }
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j, boolean turned, int num, int dir,
                    Integer[][][][][] memo) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != num) {
            return 0;
        }

        int turnedIdx = turned ? 1 : 0;
        int numIdx = num == 2 ? 1 : 0;
        if (memo[i][j][turnedIdx][numIdx][dir] != null) {
            return memo[i][j][turnedIdx][numIdx][dir];
        }

        int nextNum = (num == 2) ? 0 : 2;
        int dx = DIRS[dir][0], dy = DIRS[dir][1];
        int res = 1 + dfs(grid, i + dx, j + dy, turned, nextNum, dir, memo);

        if (!turned) {
            int nextDir = (dir + 1) % 4;
            int ndx = DIRS[nextDir][0], ndy = DIRS[nextDir][1];
            res = Math.max(res, 1 + dfs(grid, i + ndx, j + ndy, true, nextNum, nextDir, memo));
        }

        memo[i][j][turnedIdx][numIdx][dir] = res;
        return res;
    }
}
