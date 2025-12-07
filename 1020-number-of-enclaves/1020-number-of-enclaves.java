class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][]vis = new boolean[n][m];
        int count=0;
        for(int i=0;i<m;i++)
        {
            //traverse 1st row
            if(grid[0][i]==1 && !vis[0][i])
            {
                dfs(0,i,vis,grid);
            }
            //traverse last row
            if(grid[n-1][i]==1 && !vis[n-1][i])
            {
                dfs(n-1,i,vis,grid);
            }
        }
        for(int i=0;i<n;i++)
        {
            //traverse 1st col
            if(grid[i][0]==1 && !vis[i][0])
            {
                dfs(i,0,vis,grid);
            }
            //traverse last col
            if(grid[i][m-1]==1 && !vis[i][m-1])
            {
                dfs(i,m-1,vis,grid);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && !vis[i][j])
                {
                    count++;
                }
            }
        }
        return count;
    }
    static void dfs(int row,int col,boolean[][]vis,int[][]grid)
    {
        vis[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        int[][]dirs={{-1,0},{1,0},{0,1},{0,-1}};
        for(int []d : dirs)
        {
            int nr = row+d[0];
            int nc = col+d[1];
            if(nr>=0 && nc>=0 && nr<n && nc<m && !vis[nr][nc] && grid[nr][nc]==1)
            {
                dfs(nr,nc,vis,grid);
            }
        }
    }
}