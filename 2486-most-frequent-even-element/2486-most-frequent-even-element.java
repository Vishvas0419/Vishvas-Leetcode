class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int result = -1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                int freq = map.get(nums[i]);
                if(freq>maxFreq || (freq==maxFreq && nums[i]<result)){
                    maxFreq = freq;
                    result = nums[i];
                }

            }
        }
        return result;
        
    }
}