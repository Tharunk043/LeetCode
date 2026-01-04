class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i]>n) nums[i] = n+1;
        }
        for(int i = 0;i<n;i++){
            int val = Math.abs(nums[i]);
            if(val>=1 && val<=n){
                int ind = val-1;
                if(nums[ind]>0) nums[ind] = -nums[ind];
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0) return i+1;
        }
        return n+1;
    }
}
