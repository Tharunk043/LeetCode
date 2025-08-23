class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        // Compute sum of first k elements
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;

        // Slide window
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];  // add new, remove old
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum / k;
    }
}
