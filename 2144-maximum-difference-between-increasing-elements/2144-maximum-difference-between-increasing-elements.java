class Solution {
    public int maximumDifference(int[] nums) {
        int minVal = nums[0];      // smallest number seen so far
        int maxDiff = -1;          // answer to return

        int i = 1; // start from second element
        while (i < nums.length) {
            if (nums[i] > minVal) {
                maxDiff = Math.max(maxDiff, nums[i] - minVal);
            } else {
                minVal = nums[i]; // update min if we find a smaller number
            }
            i++;
        }

        return maxDiff;
    }
}
