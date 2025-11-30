class Solution {
    class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time)
        {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                }
                else if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int maxTime = 0;
        //make 2d directional array for finding fresh oranges that can be rotten 
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
            while(!q.isEmpty())
            {
                Pair curr = q.poll();
                int r = curr.row; int c = curr.col; 
                int t = curr.time;
                maxTime = Math.max(maxTime,t);
                for(int [] d : dirs)
                {
                    int newRow = r + d[0]; // shift row
                    int newCol = c + d[1]; // shift col
                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1)
                    {
                        grid[newRow][newCol] = 2; //rot it
                        fresh--;
                    //add the new rotten orange to q with time+1
                        q.add(new Pair(newRow,newCol,t+1));
                    }
                }
            } 
            return fresh==0 ? maxTime : -1;

    }
}