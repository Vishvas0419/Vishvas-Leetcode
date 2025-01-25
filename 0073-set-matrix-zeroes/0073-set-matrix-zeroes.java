class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;   
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, i, m);
                    markCol(matrix, j, n);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -10) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public void markRow(int[][] matrix, int row, int cols) {
        for (int j = 0; j < cols; j++) {
            if (matrix[row][j] != 0) {
                matrix[row][j] = -10; 
            }
        }
    }
    public void markCol(int[][] matrix, int col, int rows) {
        for (int i = 0; i < rows; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = -10;
            }
        }
    }
}