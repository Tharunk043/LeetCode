class Solution {
    public int singleNonDuplicate(int[] nums) {
        int sing = 0;
        for(int i :nums){
            sing ^=i;
        }
        return sing;
    }
}