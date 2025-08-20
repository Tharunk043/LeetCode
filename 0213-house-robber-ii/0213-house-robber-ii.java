class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int lastskipedloot = robberhelp(nums,0,nums.length-2);
        int firstskipedloot = robberhelp(nums,1,nums.length-1);
        return Math.max(lastskipedloot,firstskipedloot);
    }
    int robberhelp(int[] nums,int start,int end){
        int len = end-start+1;
        int [] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);
        for(int i = 2;i<len;i++){
            dp[i] = Math.max(dp[i-2]+nums[start+i],dp[i-1]);
        }
        return dp[len-1];
    }
}
