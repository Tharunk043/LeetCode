class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max = 0;
        for (int[] row : dimensions) {
            int curr = row[0] * row[0] + row[1] * row[1];
            max = Math.max(curr, max);
        }

        int maxArea = 0;
        for (int[] row : dimensions) {
            if (row[0] * row[0] + row[1] * row[1] == max) {
                maxArea = Math.max(maxArea, row[0] * row[1]);
            }
        }

        return maxArea;
    }
}
