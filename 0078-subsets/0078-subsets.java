class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,new ArrayList<>(),nums,res);
        return res;
    }
    public void backtrack(int start,List<Integer> tempset,int[] nums,List<List<Integer>> res){
        res.add(new ArrayList<>(tempset));
        for(int i = start; i<nums.length;i++){
            tempset.add(nums[i]);
            backtrack(i+1,tempset,nums,res);
            tempset.remove(tempset.size()-1);
        }
    }

}
