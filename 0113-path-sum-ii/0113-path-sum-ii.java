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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;
        
        path.add(node.val);
        target -= node.val;
        
        // if leaf and sum matches
        if (node.left == null && node.right == null && target == 0) {
            res.add(new ArrayList<>(path));  // add a copy
        } else {
            dfs(node.left, target, path, res);
            dfs(node.right, target, path, res);
        }
        
        // backtrack
        path.remove(path.size() - 1);
    }
}
