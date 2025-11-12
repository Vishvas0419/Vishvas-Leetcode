class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] result = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //min heap
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer,Integer>e : map.entrySet())
        {
            pq.offer(e);
            if(pq.size()>k) pq.poll();
        }
        int i = 0;
        while(!pq.isEmpty())
        {
            result[i++] = pq.poll().getKey();
        }
        return result;
    }
}