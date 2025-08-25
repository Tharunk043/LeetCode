import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        int start = nums[0]; // beginning of current range
        
        for (int i = 1; i <= nums.length; i++) {
            // End of array OR break in consecutive sequence
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    res.add(String.valueOf(start)); // single element
                } else {
                    res.add(start + "->" + nums[i - 1]); // range
                }
                // Start new range if not at end
                if (i < nums.length) start = nums[i];
            }
        }
        return res;
    }
}
