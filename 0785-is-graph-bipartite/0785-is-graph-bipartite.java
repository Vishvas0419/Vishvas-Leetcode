class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int u : graph[i])
            {
                adj.get(i).add(u);
            }
        }
        int[]color = new int[n];
        for(int i=0;i<n;i++) color[i] = -1;
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(!dfs(i,0,color,adj)) return false;
            }
        }
        return true;
    }
    boolean dfs(int node,int col,int[]color,List<List<Integer>>adj)
    {
        color[node] = col;
        for(int nbr : adj.get(node))
        {
            //if not colored then call dfs
            if(color[nbr]==-1)
            {
                if(!dfs(nbr,1-col,color,adj)) return false;
            }
            else if(color[nbr]==col) return false;
            //if this curr node is previously colored and have color as same as the color that we have (col), then return false beacuse their cant be two adj nodes with same color  
        }
        return true;
    }
}