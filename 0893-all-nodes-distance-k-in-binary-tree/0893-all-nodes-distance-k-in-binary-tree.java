/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, parent);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (level == k) break;  // nodes in queue are final answer

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // move left
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.add(curr.left);
                }

                // move right
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.add(curr.right);
                }

                // move to parent
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    visited.add(parent.get(curr));
                    q.add(parent.get(curr));
                }
            }

            level++;
        }

        // Now all nodes in the queue are at distance k
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) ans.add(q.poll().val);
        return ans;
    }

    private void buildParent(TreeNode root, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
}
