class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, 0, 0, target);
        return count;
    }

    private void backtrack(int[] nums, int index, int sum, int target) {
        if(index == nums.length) {
            if(sum == target) count++;
            return;
        }

        // choose +
        backtrack(nums, index + 1, sum + nums[index], target);

        // choose -
        backtrack(nums, index + 1, sum - nums[index], target);
    }
}
