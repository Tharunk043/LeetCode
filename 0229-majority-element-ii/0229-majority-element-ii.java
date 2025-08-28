class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res= new ArrayList<>();
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i :nums){
            if(map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        for(int i :nums){
            if(map.get(i)>n/3){ 
                if(!res.contains(i))
                res.add(i);
            }
        }
    return res;
    }
}