class Solution {
    public int mySqrt(int x) {
        if(x<=1) return x;
        int ans = 0;
        int left = 1;
        int right = x/2;
        while(left<=right){
            int mid = (left+right)/2;
            if((long)mid*mid==x) return mid;
            else if((long)mid*mid<x){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
}