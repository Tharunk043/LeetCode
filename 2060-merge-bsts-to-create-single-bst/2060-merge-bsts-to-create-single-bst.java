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
    public TreeNode canMerge(List<TreeNode> trees) {
        // Map root value -> tree
        Map<Integer, TreeNode> rootMap = new HashMap<>();
        // Keep track of all leaf values
        Set<Integer> leafValues = new HashSet<>();

        for (TreeNode t : trees) {
            rootMap.put(t.val, t);
            if (t.left != null) leafValues.add(t.left.val);
            if (t.right != null) leafValues.add(t.right.val);
        }

        // Find the global root (a root that is not any leaf)
        TreeNode root = null;
        for (TreeNode t : trees) {
            if (!leafValues.contains(t.val)) {
                root = t;
                break;
            }
        }
        if (root == null) return null; // no valid root

        // Try to build the BST
        if (!dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE, rootMap))
            return null;

        // All trees must be merged (only root left in map)
        return rootMap.size() == 1 ? root : null;
    }

    private boolean dfs(TreeNode node, int low, int high, Map<Integer, TreeNode> rootMap) {
        if (node == null) return true;
        // BST property
        if (node.val <= low || node.val >= high) return false;

        // If this node is a root of another tree, merge
        if (rootMap.containsKey(node.val) && rootMap.get(node.val) != node) {
            TreeNode mergeTree = rootMap.get(node.val);
            node.left = mergeTree.left;
            node.right = mergeTree.right;
            rootMap.remove(node.val);
        }

        return dfs(node.left, low, node.val, rootMap) &&
               dfs(node.right, node.val, high, rootMap);
    }
}
