class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    int height(TreeNode root){
        if(root==null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        diameter = Math.max(diameter,lh+rh);
        return 1+Math.max(lh,rh);
    }

    
}
