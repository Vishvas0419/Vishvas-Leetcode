class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int i=0,j=0;
        long sum = 0,maxSum = 0;

        while(j<nums.length)
        {
            sum += nums[j];
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(j-i+1==k)
            {
                if(map.size()==k) //if all elem in window is diff
                {
                    maxSum = Math.max(maxSum,sum);
                }
                //shrink the window immediately
                map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                if(map.get(nums[i])==0)
                {
                    map.remove(nums[i]);
                }
                sum = sum-nums[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }
}