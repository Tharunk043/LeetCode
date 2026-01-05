class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<right){
            int l = Math.min(height[left],height[right]);
            int b = right -left;
            int curr = l*b;
            max = Math.max(curr,max);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}