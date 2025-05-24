class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false, foundY = false;
            TreeNode parentX = null, parentY = null;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) {
                    if (current.left.val == x) {
                        foundX = true;
                        parentX = current;
                    } else if (current.left.val == y) {
                        foundY = true;
                        parentY = current;
                    }
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    if (current.right.val == x) {
                        foundX = true;
                        parentX = current;
                    } else if (current.right.val == y) {
                        foundY = true;
                        parentY = current;
                    }
                    queue.offer(current.right);
                }
            }

            // If both found at same level, check if they have different parents
            if (foundX && foundY) {
                return parentX != parentY;
            }

            // If one is found but not both, they are not cousins
            if (foundX || foundY) {
                return false;
            }
        }

        return false;
    }
}
