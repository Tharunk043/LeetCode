import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        boolean ok = true;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            if (i % 2 == 1) {
                reverse(grid[i]);
            }
            for (int x : grid[i]) {
                if (ok) ans.add(x);
                ok = !ok;
            }
            if (i % 2 == 1) {
                reverse(grid[i]);  // restore if necessary
            }
        }

        return ans;
    }

    private void reverse(int[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}
