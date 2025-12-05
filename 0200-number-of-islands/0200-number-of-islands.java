class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] vis = new boolean[n][m];
        int count = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!vis[i][j] && grid[i][j]=='1')
                {
                    count++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return count;
    }
    private void bfs(int r,int c,boolean[][]vis,char[][]grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        vis[r][c] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int [][]dirs = {{0,1},{0,-1},{-1,0},{1,0}};
            for(int[]d : dirs)
            {
                int nr = row + d[0];
                int nc = col + d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1'&& !vis[nr][nc])
                {
                    vis[nr][nc] = true;
                    q.add(new Pair(nr,nc));
                }
            }            
        }  
    }
}