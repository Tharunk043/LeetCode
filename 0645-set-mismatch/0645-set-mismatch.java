import java.util.*;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        
        Set<Integer> seen = new HashSet<>();
        int actualSum = 0;
        int duplicate = -1;
        
        for (int num : nums) {
            if (seen.contains(num)) {
                duplicate = num;
            }
            seen.add(num);
            actualSum += num;
        }
        
        int expectedSum = n * (n + 1) / 2;
        int missing = expectedSum - (actualSum - duplicate);
        
        res[0] = duplicate;
        res[1] = missing;
        return res;
    }
}
