class Solution {
    public void moveZeroes(int[] nums) {
        int zeros = 0;
        int ind = 0;
        for(int i :nums){
            if(i!=0) nums[ind++] =i;
            else zeros++;
        }
        while(zeros!=0){
            nums[ind++] = 0;
            zeros--;
        }
    }
}