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
    public int minDepth(TreeNode root) {
        int depth  =1;
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            for(int i =0;i<levelsize;i++){
            TreeNode curr = queue.poll();
            if(curr.left==null && curr.right==null){
                return depth;
            }
            if(curr.left!=null) queue.offer(curr.left);
            if(curr.right!=null) queue.offer(curr.right);
            }
            depth++;
        }
        return depth;

    }

}