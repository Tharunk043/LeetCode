class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxlen = 0;
        int[] dp = new int[nums.length];
        for(int i = 1;i<nums.length;i++){
            for(int j =0;j<i;j++){
                if(nums[i]>nums[j]){
                if(dp[j]+1>dp[i]) dp[i] = Math.max(dp[j]+1,dp[i]);
                maxlen = Math.max(maxlen,dp[i]);
                }

            }
        }
        
        return maxlen+1;
    
        


    }
}