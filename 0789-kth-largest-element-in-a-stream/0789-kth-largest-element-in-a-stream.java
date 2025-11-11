class KthLargest {
    public PriorityQueue<Integer>pq;
    public int K;
    public KthLargest(int k, int[] nums) {
        K=k;
        pq = new PriorityQueue<>();
        for(int num : nums) 
        {
            pq.offer(num);
            if(pq.size()>k) pq.poll(); //min elem will be popped
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>K) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */