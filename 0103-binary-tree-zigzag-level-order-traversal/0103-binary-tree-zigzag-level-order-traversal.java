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
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 1;
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int ls = queue.size();
            if(flag==1){
            for(int i = 0;i<ls;i++){
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            res.add(level);
            flag=0;
            }else{
                Stack<Integer> stack = new Stack<>();
                for(int i = 0;i<ls;i++){
                    TreeNode curr = queue.poll();
                    stack.push(curr.val);
                    if(curr.left!=null) queue.offer(curr.left);
                    if(curr.right!=null) queue.offer(curr.right);
                }
                while(!stack.isEmpty()){
                    level.add(stack.pop());
                }
                res.add(level);
                flag=1;
            }
        }
        return res;
    }
}