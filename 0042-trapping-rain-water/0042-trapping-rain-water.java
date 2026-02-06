class Solution {
    public int trap(int[] height) {
        int lm = 0;
        int rm = 0;
        int left = 0;
        int right = height.length-1;
        int water = 0;
        while(left<right){
            if(height[left]<height[right]){
                lm = Math.max(lm,height[left]);
                water+=lm-height[left];
                left++;
            }else{
                rm = Math.max(rm,height[right]);
                water+=rm-height[right];
                right--;
            }
        }
        return water;
    }
}