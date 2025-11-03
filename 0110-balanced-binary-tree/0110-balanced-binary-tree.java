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
    public boolean isBalanced(TreeNode root) {
        return findHeight(root)!=-1;
    }
    public int findHeight(TreeNode root)
    {
        if(root==null) return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        if(leftHeight==-1 || rightHeight==-1) return -1;//we dont have to check the other tree if any one of the tree's height is -1
        if(Math.abs(leftHeight-rightHeight)>1) return -1;//condition for balanced tree
        return 1+Math.max(leftHeight,rightHeight);
    }
}