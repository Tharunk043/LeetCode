class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;

        // ✅ Check if current node violates BST property
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // Recursively check left and right subtrees
        return helper(root.left, min, root.val) &&
               helper(root.right, root.val, max);
    }
}
