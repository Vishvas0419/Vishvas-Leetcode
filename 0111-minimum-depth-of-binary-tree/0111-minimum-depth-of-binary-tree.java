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
        if(root==null) return 0;
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        //if left is null recurse only rightHeight
        if(root.left==null) return 1+rightHeight;
        //if right is null recurse only leftHeight
        if(root.right==null) return 1+leftHeight;
        //if both childs exist, take min of the two
        return 1+Math.min(leftHeight,rightHeight);
    }
}