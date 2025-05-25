class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // If leaf node, check if targetSum matches node value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recur for left and right subtree with updated targetSum
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}
