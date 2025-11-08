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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int N = preorder.length;
        return constructTree(preorder,inorder,0,N-1,0,N-1);
    }
    public TreeNode constructTree(int[] pre, int[] in,int preStart,int preEnd,int inStart,int inEnd)
    {
        if(preStart>preEnd || inStart>inEnd) return null;
        int rootData = pre[preStart];//first node in preorder is root
        TreeNode root = new TreeNode(rootData);
        int rootIndexIninorder = in[inStart];
        for(int i=inStart;i<=inEnd;i++)
        {
            if(in[i]==rootData)
            {
                rootIndexIninorder = i;
                break;
            }
        }
        int leftSize = rootIndexIninorder - inStart;
        root.left = constructTree(pre,in,preStart+1,preStart+leftSize,inStart,rootIndexIninorder-1);
        root.right = constructTree(pre,in,preStart+leftSize+1,preEnd,rootIndexIninorder+1,inEnd);
        return root;
        
    }
}