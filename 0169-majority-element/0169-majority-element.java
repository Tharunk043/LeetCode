class Solution {
    public int majorityElement(int[] nums) {
        int votes = 1;
        int maj = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(maj==nums[i]) votes++;
            else if(votes==0) {
                maj = nums[i];
                votes = 1;
            }else{
                votes--;
            }
        }
        return maj;
    }
}