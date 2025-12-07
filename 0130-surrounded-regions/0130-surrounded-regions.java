class Solution {
    public void solve(char[][] board) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = board.length;
        int m = board[0].length;
        boolean [][] vis = new boolean[n][m];
        int[]delrow = {-1,0,+1,0};
        int[]delcol = {0,1,0,-1};
        for(int i=0;i<m;i++)
        {
            //traverse 1st row
            if(!vis[0][i]  && board[0][i]=='O')
            {
                dfs(0,i,vis,board,delrow,delcol);
            }
            //traverse last row
            if(!vis[n-1][i]  && board[n-1][i]=='O')
            {
                dfs(n-1,i,vis,board,delrow,delcol);
            }
        }
        for(int i=0;i<n;i++)
        {
            //traverse 1st col
            if(!vis[i][0]  && board[i][0]=='O')
            {
                dfs(i,0,vis,board,delrow,delcol);
            }
            //traverse last col
            if(!vis[i][m-1]  && board[i][m-1]=='O')
            {
                dfs(i,m-1,vis,board,delrow,delcol);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O' && !vis[i][j])
                {
                    board[i][j]='X';
                }
            }
        }

    }
    static void dfs(int row,int col,boolean[][]vis,char[][]board,int[]delrow,int[]delcol)
    {
        vis[row][col]=true;
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<4;i++)
        {
            int nr = row + delrow[i];
            int nc = col + delcol[i];
            if(nr>=0 && nc>=0 && nr<n && nc<m && board[nr][nc]=='O' && !vis[nr][nc])
            {
                dfs(nr,nc,vis,board,delrow,delcol);
            }
        }
    }
}