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
    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        //their will be two cases :
        //if the nodes to be swapped are not adjacent 
        if(first!=null && last!=null) swap(first,last);
        else if(first!=null && middle!=null) swap(first,middle);
        //and case if the nodes to be swapped are adjacent 
    }
    public void inorder(TreeNode root)
    {
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && root.val<prev.val)
        {
//if this is the first violation mark them as 'first' & 'middle'
            if(first==null)
            {
                first = prev;
                middle = root;
            }
//if their is second violation,mark the curr node as 'last'
            else {
                last = root;
            }
        }
        prev=root; //mark curr node as prev
        inorder(root.right);
    }
    public void swap(TreeNode node1,TreeNode node2)
    {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}