class Solution {
    public int subarraySum(int[] nums, int k) {
        //HashMap + Prefix Sum (complement method)
        Map<Integer,Integer> map = new HashMap<>();
        //key = sum , value = freq of the sums
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int num:nums)
        {
            sum+=num;
            if(map.containsKey(sum-k))
            {
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}