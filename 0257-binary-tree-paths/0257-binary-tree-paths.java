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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        if(root!=null)
        {
            dfs(root,path,result);
        }
        return result;
    }
    public void dfs(TreeNode root,StringBuilder path,List<String>result)
    {
        int len = path.length();
        if(root==null) return;
        if(len > 0) path.append("->");
        path.append(root.val);

        if(root.left==null && root.right==null)
        {
            result.add(path.toString());
        }
        else {
            dfs(root.left,path,result);
            dfs(root.right,path,result);
        }
        path.setLength(len);
    }

}