import java.util.*;

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        // Prefix distinct counts
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            seen.add(nums[i]);
            prefix[i] = seen.size();
        }
        
        // Suffix distinct counts
        seen.clear();
        for (int i = n - 1; i >= 0; i--) {
            seen.add(nums[i]);
            suffix[i] = seen.size();
        }
        
        // Build result
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int right = (i + 1 < n) ? suffix[i + 1] : 0;
            res[i] = prefix[i] - right;
        }
        
        return res;
    }
}
