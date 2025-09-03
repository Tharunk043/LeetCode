class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }
    public void mergesort(int[]nums,int lb,int ub){
        if(lb<ub){
            int mid = (lb+ub)/2;
            mergesort(nums,lb,mid);
            mergesort(nums,mid+1,ub);
            merge(nums,lb,mid,ub);
        }
    }
    void merge(int[] nums,int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int ind = 0;
        while(left<=mid && right<=high ){
            if(nums[left]<=nums[right]){
                temp[ind++] = nums[left++];
            }else{
                temp[ind++] = nums[right++];
            }
        }
        while(left<=mid){
            temp[ind++] = nums[left++];
        }
        while(right<=high){
            temp[ind++] = nums[right++];
        }
        for(int i = 0;i<temp.length;i++){
            nums[low+i] = temp[i];
        }
    }
}