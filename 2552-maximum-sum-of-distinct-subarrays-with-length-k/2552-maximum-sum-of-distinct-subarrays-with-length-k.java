class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int i=0;int j=0; long sum = 0; long max = 0;
        while(j<nums.length)
        {
            sum += nums[j];
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            //when window reaches size k
            if(j-i+1 == k)
            {
                if(map.size()==k) max = Math.max(max,sum);
            //slide the window = remove nums[j] from sum and map
                sum -= nums[i];
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }
            j++;
        }
        return max;
    }
}