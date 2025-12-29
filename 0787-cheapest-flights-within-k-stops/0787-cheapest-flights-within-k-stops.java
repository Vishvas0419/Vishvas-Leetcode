class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        class Pair{
            // For adjacency list: (node, price)
            int node;
            int wt;
            Pair(int node,int wt)
            {
                this.node = node;
                this.wt = wt;
            }
        }
        class State{
        // For queue: (city, cost so far, stops used)
            int city;
            int cost;
            int stops;
            State(int city,int cost,int stops)
            {
                this.city = city;
                this.cost = cost;
                this.stops = stops;
            }
        }
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }   
        for(int[]f : flights)
        {
            // for adj list : (i) --> {node, price}
            adj.get(f[0]).add(new Pair(f[1],f[2]));
        }
        Queue<State> q = new LinkedList<>();
        q.add(new State(src,0,0));
        int dist[] = new int[n];
        for(int i=0;i<n;i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        while(!q.isEmpty())
        {
            State curr = q.poll();
            if(curr.stops > k) continue;
            int city = curr.city;
            int cost = curr.cost;
            // total cost so far from src → current city
            for(Pair p : adj.get(city))
            {
                int nbr = p.node;
                int price = p.wt;
                // the price of ONE flight (edge weight)
                int newcost = cost + price;
                if(newcost<dist[nbr])
                {
                    dist[nbr] = newcost;
                    q.add(new State(nbr,newcost,curr.   stops+1));
                }
            }
        }
        //if distance of dest is still inf in the array then return -1 else return distance calculated so far 
        return dist[dst]==Integer.MAX_VALUE ? -1  //if
               : dist[dst];  //else
    }
}