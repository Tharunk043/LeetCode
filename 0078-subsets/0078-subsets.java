class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,new ArrayList<Integer>(),res,nums);
        return res;
    }
    void backtrack(int start,List<Integer> tempset,List<List<Integer>> res,int[] nums){
        res.add(new ArrayList<>(tempset));
        for(int i =start;i<nums.length;i++){
            tempset.add(nums[i]);
            backtrack(i+1,tempset,res,nums);
            tempset.remove(tempset.size()-1);
        }
    }

}