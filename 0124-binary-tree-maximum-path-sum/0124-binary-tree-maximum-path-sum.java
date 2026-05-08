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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        // If a side gives negative gain, ignore it (take 0)
        int left  = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        // At curr node, best path through it = left+node+right
        maxSum = Math.max(maxSum, left + right + node.val);
        // But return only ONE side to parent (can't go both ways up)
        return node.val + Math.max(left, right);
    }
}