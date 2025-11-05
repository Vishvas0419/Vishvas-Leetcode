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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int N = inorder.length;
        return constructTree(inorder,postorder,0,N-1,0,N-1);        
    }
    public TreeNode constructTree(int[] inorder, int[] postorder,int inStart,int inEnd,int postStart,int postEnd)
    {
        if(inStart>inEnd || postStart>postEnd) return null;
        int rootData = postorder[postEnd];
        TreeNode root = new TreeNode(rootData);
        int rootIndexInInOrder = -1;
        for(int i=inStart;i<=inEnd;i++)
        {
            if(inorder[i]==rootData){
                rootIndexInInOrder = i;
                break;
            }
        }
        int leftSize = rootIndexInInOrder - inStart;
        root.left = constructTree(inorder,postorder,inStart,rootIndexInInOrder-1,postStart,postStart+leftSize-1);
        root.right = constructTree(inorder,postorder,rootIndexInInOrder+1,inEnd,postStart+leftSize,postEnd-1);
        return root;

    }
}