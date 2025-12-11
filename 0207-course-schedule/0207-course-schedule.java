class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = numCourses; int n = prerequisites.length;
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int []indegree = new int[V];
        for(int i=0;i<V;i++)
        {
            for(int nbr : adj.get(i)) indegree[nbr]++;
        }
        Queue<Integer>q  = new LinkedList<>();
        for(int i=0;i<V;i++) if(indegree[i]==0) q.add(i);
        ArrayList<Integer>topo = new ArrayList<>();
        while(!q.isEmpty())
        {
            int node = q.poll();
            topo.add(node);
            for(int nbr : adj.get(node))
            {
                indegree[nbr]--;
                if(indegree[nbr]==0) q.add(nbr);
            }
        }
        if(topo.size() == V) return true;
        return false;  
    }
}