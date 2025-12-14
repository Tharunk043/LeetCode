class Solution {
    public int majorityElement(int[] nums) {
        int vote= 1;
        int maj= nums[0];
        for(int i=1;i<nums.length;i++){
            if(maj==nums[i]){
                vote++;
            }else if(vote==0){
                maj = nums[i];
                vote = 1;
            }else{
                vote--;
            }
        }
        return maj;
    }
}