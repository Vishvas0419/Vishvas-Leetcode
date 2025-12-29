class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        class Pair{
            int node;
            int time;
            Pair(int node,int time)
            {
                this.node = node;
                this.time = time;
            }
        }
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int []e : times)
        {
            int u = e[0];
            int v = e[1];
            int time = e[2];
            adj.get(u).add(new Pair(v,time));
        }
        int[]dist = new int[n+1];
        for(int i=1;i<=n;i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        pq.add(new Pair(k,0));
        while(!pq.isEmpty())
        {
                Pair curr = pq.poll();
                int node = curr.node;
                int currtime = curr.time;
                // if we already have a better time,skip
                if(currtime > dist[node]) continue; 
            for(Pair p : adj.get(node))
            {
                int nbr = p.node;
                int wt = p.time;
                int newtime = currtime + wt;
                if(newtime<dist[nbr]){ 
                dist[nbr]=newtime;
                pq.add(new Pair(nbr,newtime));
                }
            }
        }
        int ans = 0;
        for(int i=1;i<=n;i++)
        {
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,dist[i]);
        }
        return ans;
    }
}