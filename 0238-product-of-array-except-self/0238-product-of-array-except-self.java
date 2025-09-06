class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];
        for(int i = 0,temp = 1;i<nums.length;i++){
            left[i] = temp;
            temp *=nums[i];
        }
        for(int i = nums.length-1,temp = 1;i>=0;i--){
            right[i] = temp;
            temp *=nums[i];
        }
        for(int i = 0 ;i<res.length;i++){
            res[i] = left[i]* right[i];
        }
        return res;

    }
}