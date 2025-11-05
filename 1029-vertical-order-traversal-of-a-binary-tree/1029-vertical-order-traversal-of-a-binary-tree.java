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

    class Pair {
        TreeNode node;
        int hd;
        int row;

        Pair(TreeNode node, int hd, int row) {
            this.node = node;
            this.hd = hd;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        // Now store: hd -> list of (row, val)
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));  // hd=0, row=0

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int hd = curr.hd;
            int row = curr.row;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(new int[]{row, node.val});

            if (node.left != null)
                q.offer(new Pair(node.left, hd - 1, row + 1));

            if (node.right != null)
                q.offer(new Pair(node.right, hd + 1, row + 1));
        }

        // For each column, sort by row then value
        for (int hd : map.keySet()) {
            List<int[]> list = map.get(hd);

            Collections.sort(list, (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];   // sort by row
                return a[1] - b[1];                    // same row -> sort by value
            });

            List<Integer> col = new ArrayList<>();
            for (int[] arr : list)
                col.add(arr[1]);

            result.add(col);
        }

        return result;
    }
}
