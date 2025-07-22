class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int remainderElem = target - nums[i];
            if(map.containsKey(remainderElem))
            {
                return new int[]{map.get(remainderElem),i};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return new int []{0,0};
    }
}