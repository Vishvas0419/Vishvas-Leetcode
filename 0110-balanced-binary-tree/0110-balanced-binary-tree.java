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
    public int height(TreeNode node)
    {
        if(node==null || node.left==null && node.right==null) return 0;
        int l_height = height(node.left); 
        int r_height = height(node.right);
        return 1+Math.max(l_height,r_height);
    }
    public boolean isBalanced(TreeNode root) {
       if(root==null || root.left==null && root.right==null) return true;
        int l = height(root.left);
        if(root.left!=null) l++;
        int r = height(root.right);
        if(root.right!=null) r++;
        if(Math.abs(l-r)>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}