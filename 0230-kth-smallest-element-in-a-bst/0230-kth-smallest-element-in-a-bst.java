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
    public int kthSmallest(TreeNode root, int k) {
        int [] kthSmallest = new int[1];
        kthSmallest[0] = Integer.MAX_VALUE;
        int [] count = new int [1];
        count [0] = 0;
        inOrder(root,k,count,kthSmallest);
        return kthSmallest[0];
    }
    public void inOrder(TreeNode root,int k,int []count,int[] kthSmallest){
        if(root==null) return;
        inOrder(root.left,k,count,kthSmallest); //L
        count[0]++;
        if(count[0]==k){
            kthSmallest[0]=root.val;
            return; //N
        }
        inOrder(root.right,k,count,kthSmallest); //R
    }

}