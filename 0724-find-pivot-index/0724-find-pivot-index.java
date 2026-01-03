class Solution {
    public int pivotIndex(int[] nums) {
        int rs = 0;
        int ls = 0;
        for(int i :nums){
            rs+=i;
        }
        for(int i = 0;i<nums.length;i++){
            rs-=nums[i];

            if(rs==ls) return i;
            ls+=nums[i];
        }
        return -1;
    }
}