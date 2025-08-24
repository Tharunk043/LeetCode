class Solution {
    public String triangleType(int[] nums) {
        if (nums.length < 3) return "none";

        int a = nums[0], b = nums[1], c = nums[2];
        
        // Triangle inequality check
        if (a + b <= c || b + c <= a || a + c <= b) {
            return "none";
        }

        // Types of triangle
        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
