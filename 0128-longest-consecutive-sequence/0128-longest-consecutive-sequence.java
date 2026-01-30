class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max= 0;
        for(int i :nums) set.add(i);
        for(int i:set){
            if(!set.contains(i-1)){
                int curr = i;
                int count = 1;
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}