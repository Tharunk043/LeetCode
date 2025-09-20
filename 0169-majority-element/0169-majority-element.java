class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0],votes = 1;
        for(int i=1;i<nums.length;i++){
            if(votes==0){
                votes++;
                maj =nums[i];
            }else if(maj==nums[i]){
                votes++;
            }else{
                votes--;
            }
        }
        return maj;
    }
}