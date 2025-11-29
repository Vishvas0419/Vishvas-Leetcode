class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = isConnected[0].length;
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if(isConnected[i][j] == 1 && i!=j)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean []vis = new boolean[V];
        int count = 0;
        for(int i = 0;i<V;i++)
        {
            if(!vis[i])
            {
                count++;
                dfs(i,adj,vis);
            }
        }
        return count;

    }
    private void dfs(int curr,ArrayList<ArrayList<Integer>>adj,boolean []vis)
    {
        vis[curr] = true;
        for(int nbr : adj.get(curr))
        {
            if(!vis[nbr])
            {
                dfs(nbr,adj,vis);
            }
        }
    }
}