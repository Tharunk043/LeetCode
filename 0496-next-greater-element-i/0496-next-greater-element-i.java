class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = nums2.length-1;i>=0;i--){
            int num = nums2[i];
            while(!stack.isEmpty() && stack.peek()<=num) stack.pop();
            map.put(num,stack.isEmpty()?-1:stack.peek());
            stack.push(num);
        }
        for(int i =0;i<res.length;i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}