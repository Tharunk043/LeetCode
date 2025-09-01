import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int left = 0, res = 1;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // cost to make all numbers in [left..right] equal to nums[right]
            while ((long)nums[right] * (right - left + 1) - sum > k) {
                sum -= nums[left];
                left++;
            }

            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
