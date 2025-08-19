class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long count = 0; // counts consecutive zeros
        
        for (int num : nums) {
            if (num == 0) {
                count++;
                res += count; // every new zero adds 'count' new subarrays
            } else {
                count = 0; // reset when non-zero
            }
        }
        
        return res;
    }
}
