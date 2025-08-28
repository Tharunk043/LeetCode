import java.util.*;

class Solution {
    public int maximumProduct(int[] nums) {
        if (nums.length < 3) return 0;
        
        Arrays.sort(nums);
        int n = nums.length;
        
        int option1 = nums[n-1] * nums[n-2] * nums[n-3]; // 3 largest
        int option2 = nums[0] * nums[1] * nums[n-1];     // 2 smallest + largest
        
        return Math.max(option1, option2);
    }
}
