class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length; //rows
        int n = matrix[0].length; //cols
        //marks -10 for entire rows and cols elems which is not 0  
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, i, n); 
                    markCol(matrix, j, m);
                }
            }
        }
        //mark 0 for all the elems marked as -10
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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