class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];// (row - col + n - 1)
        boolean[] anti = new boolean[2 * n - 1];      // (row + col)
        backtrack(0,n,board,col,diag,anti,ans);
        return ans;
    }
    void backtrack(int row, int n,char[][] board,boolean[] col,boolean[] diag,boolean[] anti,List<List<String>> ans) {
        // if all queens are placed on all rows add to ans and return
        if (row == n) {
            ans.add(build(board));
            return;
        }
        for (int c = 0; c < n; c++) {
            int d = row - c + n - 1;
            int a = row + c;
            if (col[c] || diag[d] || anti[a]) continue;
            // choose
            board[row][c] = 'Q';
            col[c] = diag[d] = anti[a] = true;
            // recurse to next row for more solutions
            backtrack(row + 1, n, board, col, diag, anti, ans);
            // undo
            board[row][c] = '.';
            col[c] = diag[d] = anti[a] = false;
        }
    }

    List<String> build(char[][] board) {
    List<String> res = new ArrayList<>();
    for (char[] row : board) {
        res.add(new String(row));
    }
    return res;
}

}
