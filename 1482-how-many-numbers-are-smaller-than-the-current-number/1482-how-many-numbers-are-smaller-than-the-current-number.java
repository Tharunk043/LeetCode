import java.util.*;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(sorted[i], i); // i = how many numbers are smaller
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums[i]); // lookup count
        }

        return res;
    }
}
