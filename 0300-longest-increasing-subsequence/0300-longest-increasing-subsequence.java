class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i =1;i<nums.length;i++){
            for(int j = 0;j<i;j++ ){
                if(nums[i]>nums[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }
        int maxelement = Integer.MIN_VALUE;
        for(int i:dp){
            if(i>maxelement) maxelement = i;
        }
        return maxelement+1;//since here we using 0 index we need to add 1;
    }
}