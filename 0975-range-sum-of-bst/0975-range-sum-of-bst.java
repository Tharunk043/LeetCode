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
    List<Integer> list = new ArrayList<>();
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        inorder(root,low,high);
        int sum = 0;
        for(int i:list){
            sum+=i;
        }
        return sum;
    }
    public void inorder(TreeNode root,int low,int high){
        if(root==null){
            return ;
        }
        inorder(root.left,low,high);
        if(root.val>=low && root.val<=high){
           list.add(root.val);
        }
        inorder(root.right,low,high);
    }
}