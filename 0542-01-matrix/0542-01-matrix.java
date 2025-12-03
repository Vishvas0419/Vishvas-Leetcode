class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][]result = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    result[i][j] = 0;
                    q.add(new Pair(i,j));
                }
                else{
                    result[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
            for(int []d : dirs)
            {
                int new_r = r + d[0];
                int new_c = c + d[1];
                if(new_r>=0 && new_r<n && new_c>=0 && new_c<m && result[new_r][new_c]==-1)
                {
                    result[new_r][new_c] = result[r][c] + 1;
                    q.add(new Pair(new_r,new_c)); 
                }
            }
        }
        return result;
    }
}