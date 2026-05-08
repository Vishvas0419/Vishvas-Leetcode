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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preList = new ArrayList<>();
        preorder(root,preList);
        return preList;
    }
    void preorder(TreeNode root,List<Integer>preList)
    {
        if(root==null) return;
        preList.add(root.val);
        preorder(root.left,preList);
        preorder(root.right,preList);
    } 
}