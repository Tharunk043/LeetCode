class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        
        int longest = 0;
        
        for (int num : set) {
            // only start counting from the beginning of a sequence
            if (!set.contains(num - 1)) {
                int curr = num;
                int length = 1;
                
                while (set.contains(curr + 1)) {
                    curr++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        
        return longest;
    }
}
