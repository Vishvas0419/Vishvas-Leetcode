class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();
        int V = graph.length;
        List<List<Integer>> revList = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            revList.add(new ArrayList<>());
        }
        int[]indegree = new int[V];
        for(int u=0;u<V;u++)
        {
            for(int v : graph[u])
            {
                //Kahn algo on reverse graph
                revList.get(v).add(u); 
                indegree[u]++;
            } 
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty())
        {
            int node = q.poll();
            safeNodes.add(node);
            for(int nbr : revList.get(node))
            {
                indegree[nbr]--;
                if(indegree[nbr]==0) q.add(nbr);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;

    }
}