import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff <= 0 || valueDiff < 0) return false;

        TreeSet<Long> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            
            // Find smallest >= num
            Long ceiling = set.ceiling(num);
            if (ceiling != null && ceiling - num <= valueDiff) return true;
            
            // Find largest <= num
            Long floor = set.floor(num);
            if (floor != null && num - floor <= valueDiff) return true;
            
            set.add(num);
            
            // Maintain window size
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
