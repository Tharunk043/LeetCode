import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // ✅ Bottom-left triangle (including main diagonal) → descending
        for (int row = 0; row < n; row++) {
            sortDiagonal(grid, row, 0, false); // start from left edge
        }

        // ✅ Top-right triangle (excluding main diagonal) → ascending
        for (int col = 1; col < n; col++) {
            sortDiagonal(grid, 0, col, true); // start from top edge
        }

        return grid;
    }

    private void sortDiagonal(int[][] grid, int row, int col, boolean ascending) {
        int n = grid.length;
        List<Integer> list = new ArrayList<>();

        int r = row, c = col;
        while (r < n && c < n) {
            list.add(grid[r][c]);
            r++;
            c++;
        }

        if (ascending) {
            Collections.sort(list); // ascending
        } else {
            Collections.sort(list, Collections.reverseOrder()); // descending
        }

        r = row;
        c = col;
        int idx = 0;
        while (r < n && c < n) {
            grid[r][c] = list.get(idx++);
            r++;
            c++;
        }
    }
}
