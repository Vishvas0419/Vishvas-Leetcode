class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer>ans = new ArrayList<>();
            int m = matrix.length;
            int n = matrix[0].length;
            int top = 0, bottom = m - 1, left = 0, right = n - 1;
            while (top <= bottom && left <= right) {
                // Print top row
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
                // Print rightmost column
                for (int i = top; i <= bottom; i++) {
                   ans.add(matrix[i][right]);
                }
                right--;
                // Print bottom row (if rows are remaining)
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        ans.add(matrix[bottom][i]);
                    }
                    bottom--;
                }
            // Print leftmost column (if columns are remaining)
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        ans.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            return ans;  
    }
}