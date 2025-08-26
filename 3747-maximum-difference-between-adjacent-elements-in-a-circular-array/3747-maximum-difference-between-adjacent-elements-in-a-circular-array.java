class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n; // wrap around for circular array
            int curr = Math.abs(nums[i] - nums[next]);
            max = Math.max(max, curr);
        }
        return max;
    }
}
