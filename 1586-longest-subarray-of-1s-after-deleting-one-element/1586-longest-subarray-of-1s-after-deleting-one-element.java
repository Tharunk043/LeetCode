class Solution {
    public int longestSubarray(int[] nums) {
        int zeros =0;
        int left = 0;
        int maxlen = 0;
        for(int right = 0;right<nums.length;right++){
            if(nums[right]==0) zeros++;
            while(zeros>1){
                if(nums[left]==0) zeros--;
                left++;
            }
            maxlen = Math.max(maxlen,right-left);
        }
        return maxlen;
    }
}
