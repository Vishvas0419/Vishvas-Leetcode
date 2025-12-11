class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[]topo = new int[V];
        int i=0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            topo[i++] = node;
            for(int nbr : adj.get(node))
            {
                indegree[nbr]--;
                if(indegree[nbr]==0) q.add(nbr);
            }
        }
        // if we didn't place all courses, there is a cycle -> return empty array
        if(i != V) return new int[]{}; 
        return topo;
    }
}