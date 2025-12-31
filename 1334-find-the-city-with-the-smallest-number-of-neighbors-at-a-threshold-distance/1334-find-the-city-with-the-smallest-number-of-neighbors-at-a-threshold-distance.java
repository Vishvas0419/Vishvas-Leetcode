class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][]dist = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j] = Integer.MAX_VALUE; //for empty paths
            }
        }
        for(int []e : edges)
        {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            dist[u][v] = wt; dist[v][u] = wt; //fill for given paths
        }
        for(int i=0;i<n;i++)
        {
            dist[i][i] = 0;//dist btw same src and dest is 0 
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE)
                    {
                        dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        //find which 
        int cityCount = n+1;
        int cityno = -1;
        for(int i=0;i<n;i++)
        {
            int cnt = 0;
            for(int j=0;j<n;j++)
            {
                if(dist[i][j] <= distanceThreshold)
                {
                    cnt++;
                }
            }
            if(cnt <= cityCount)
            {
                cityCount = cnt;
                cityno = i;
            }
        }
        return cityno; 
    }
}