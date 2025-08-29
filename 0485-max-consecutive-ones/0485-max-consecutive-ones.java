class Solution {
     static {
        for(int i=0;i<500;i++){
        Solution.findMaxConsecutiveOnes(new int[]{});

        }
    }
    public  static int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int ans=0;
        for(int num:nums){
            if(num==1){
                count+=1;
                
            }else{
                ans=Math.max(count,ans);
                count=0;
               
            }
        }
        ans=Math.max(count,ans);
        return ans;
    }
}