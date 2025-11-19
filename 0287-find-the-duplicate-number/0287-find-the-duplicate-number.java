class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] bool = new boolean[nums.length+1];
        for(int i :nums){
            if(!bool[i]){
                bool[i]=true;
            }else{
                return i;
            }
        }
        return -1;
    }
}