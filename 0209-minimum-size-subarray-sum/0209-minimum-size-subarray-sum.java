class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    
        int minlen = Integer.MAX_VALUE;
        int currsum = 0;
        int left = 0;
        int right = 0;
        while(right<nums.length){
            currsum+=nums[right];
            right++;
            while(currsum>=target){
                minlen = Math.min(minlen,right-left);
                currsum-=nums[left];
                left++;
            }
        }
        return minlen==Integer.MAX_VALUE?0:minlen;
    }
}