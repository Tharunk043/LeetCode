/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean ltr = true;
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int ls = queue.size();
            List<Integer> list =new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for(int i = 0;i<ls;i++){
                TreeNode curr = queue.poll();
                if(ltr){
                    list.add(curr.val);
                }else{
                    stack.push(curr.val);
                }
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            while(!stack.isEmpty()){
                list.add(stack.pop());
            }
            res.add(list);
            ltr = !ltr;
        }
        return res;
    }
}