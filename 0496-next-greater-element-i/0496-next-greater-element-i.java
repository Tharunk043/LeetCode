import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length-1;i>=0;i--){
            int num = nums2[i];
            while(!stack.isEmpty() && stack.peek()<num){
                stack.pop();
            }
            map.put(num,(stack.isEmpty())?-1:stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        int ind = 0;
        for(int i :nums1){
            res[ind++] = map.get(i);
        }
        return res;
    }

}
