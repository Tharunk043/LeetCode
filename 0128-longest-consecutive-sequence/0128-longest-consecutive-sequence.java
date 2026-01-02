class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int longest = 0;
        for(int i:set){
            if(!set.contains(i-1)){
                int curr = i;
                int count =1;
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }
}