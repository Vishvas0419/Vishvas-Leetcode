class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>n/3) set.add(nums[i]);
        }
        for(int num : set)
        {
            list.add(num);
        }
        return list;
    }
}