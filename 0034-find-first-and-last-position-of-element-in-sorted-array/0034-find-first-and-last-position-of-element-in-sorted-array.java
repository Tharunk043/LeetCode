class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = leftsearch(nums,target);
        int r = rightsearch(nums,target);
        return new int []{l,r};
    }
    int leftsearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        int ans = -1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                ans= mid;
                right = mid-1;
            }else if(target<nums[mid]){
                right = mid-1;
            }else{
                left= mid+1;
            }
        }
        return ans;
    }
    int rightsearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        int ans = -1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                ans = mid;
                left = mid+1;
            }else if(target<nums[mid]){
                right = mid-1;
            }else{
                left= mid+1;
            }
        }
        return ans;
    }

}