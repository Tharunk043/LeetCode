class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i= 0;i<k;i++){
            sum += nums[i];
        }
        int maxsum = sum;
        int startindex = 0;
        int endindex = k;
        while(endindex<nums.length){
            sum-=nums[startindex];
            startindex++;
            sum+=nums[endindex];
            endindex++;
            maxsum = Math.max(sum,maxsum);
        }
        return (double)maxsum /k;
        
    }
}
