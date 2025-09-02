class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),res);
        return res;
    }
    public void backtrack(int start,int[] nums,ArrayList<Integer> tempset,List<List<Integer>> res){
        res.add(new ArrayList(tempset));
        for(int i = start;i<nums.length;i++){
            tempset.add(nums[i]);
            backtrack(i+1,nums,tempset,res);
            tempset.remove(tempset.size()-1);
        }
    }

}
