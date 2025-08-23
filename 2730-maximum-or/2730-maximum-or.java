class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n + 1]; // prefix OR
        long[] suf = new long[n + 1]; // suffix OR

        // build prefix OR
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] | nums[i];
        }

        // build suffix OR
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1] | nums[i];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long shifted = ((long) nums[i]) << k;
            long candidate = pre[i] | shifted | suf[i + 1];
            ans = Math.max(ans, candidate);
        }
        return ans;
    }
}
