class Solution {
    class Pair{
        int row;
        int col;
        int distance;
        Pair(int row,int col,int distance)
        {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length; 
        int m = heights[0].length;
        int [][]dist = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.add(new Pair(0,0,0));
        int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int diff = curr.distance;
            // If we reach the destination cell, return the current effort
            if (row == n-1 && col == m-1) return diff;
            for(int []dir : dirs)
            {
                int newr = dir[0] + row;
                int newc = dir[1] + col;
                if(newr>=0 && newc >=0 && newr<n &&newc<m){
                    int effort = Math.abs(heights[row][col]-heights[newr][newc]);
                    int newEffort = Math.max(effort,diff);
                    if(newEffort < dist[newr][newc])
                    {
                        dist[newr][newc] = newEffort;
                        pq.add(new Pair(newr,newc,newEffort));
                    }

                }
            }
        }
        return 0;
    }
}