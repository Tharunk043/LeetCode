class Solution {
    Integer prev = null;        // previous node value
    int count = 0;              // current frequency
    int maxCount = 0;           // max frequency found
    List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);

        // convert list -> int[]
        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            res[i] = modes.get(i);
        }
        return res;
    }

    private void handleValue(int val) {
        if (prev == null || val != prev) {
            count = 1;          // reset count for new value
        } else {
            count++;            // same as previous → increase streak
        }

        if (count > maxCount) {
            maxCount = count;
            modes.clear();
            modes.add(val);
        } else if (count == maxCount) {
            modes.add(val);
        }

        prev = val;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }
}
