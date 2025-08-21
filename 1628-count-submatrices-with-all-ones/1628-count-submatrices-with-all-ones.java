class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] height = new int[n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            // Update histogram heights
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j]++;
                }
            }

            res += countSubmatInHistogram(height);
        }

        return res;
    }

    private int countSubmatInHistogram(int[] height) {
        int n = height.length;
        int res = 0;
        int[] sum = new int[n];  // sum[j] = number of submatrices ending at column j
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int j = 0; j < n; j++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[j]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[j] = sum[prev] + height[j] * (j - prev);
            } else {
                sum[j] = height[j] * (j + 1);
            }

            res += sum[j];
            stack.push(j);
        }

        return res;
    }
}
