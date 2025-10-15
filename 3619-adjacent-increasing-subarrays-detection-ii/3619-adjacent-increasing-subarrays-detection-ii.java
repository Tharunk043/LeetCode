import java.util.List;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n < 2) return 0;  // If fewer than 2 elements, can't have two subarrays of length ≥ 1 adjacent

        int ans = 0;
        int pre = 0;   // Length of the previous strictly increasing segment
        int cur = 0;   // Length of the current strictly increasing segment

        for (int i = 0; i < n; i++) {
            cur++;  // Always extend current run by one for the current element
            
            // Check if this is the end of a strictly increasing run
            // Either at last element, or the next is not strictly greater
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                // Option 1: split the current run into two adjacent parts
                int option1 = cur / 2;
                // Option 2: use tail of previous + head of current run
                int option2 = Math.min(pre, cur);

                ans = Math.max(ans, Math.max(option1, option2));

                // Move current run to previous, reset cur
                pre = cur;
                cur = 0;
            }
        }

        return ans;
    }
}
