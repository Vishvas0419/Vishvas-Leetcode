class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //for max heap
        for(int num : stones)
        {
            pq.offer(num);
        }
        while(pq.size()>1)
        {
            int y = pq.poll(); //largest stone
            int x = pq.poll(); //2nd largest stone
            if(y!=x) pq.offer(y-x); //insert the difference
        }
        return pq.isEmpty() ? 0 : pq.peek(); //return 0 if queue is empty else return last elem from the queue
    }
}