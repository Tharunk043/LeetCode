class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101]; // since nums[i] is 1 <= nums[i] <= 100
        int res = 0;
        
        for (int x : nums) {
            res += count[x]; // every previous x forms a pair with this one
            count[x]++;      // update frequency
        }
        
        return res;
    }
}
