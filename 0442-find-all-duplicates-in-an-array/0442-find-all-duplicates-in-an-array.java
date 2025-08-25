class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;  // map value to index

            if (nums[idx] < 0) {
                // Already visited → duplicate found
                res.add(Math.abs(nums[i]));
            } else {
                // Mark as visited
                nums[idx] = -nums[idx];
            }
        }

        return res;
    }
}
