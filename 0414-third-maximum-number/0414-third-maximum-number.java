class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
        {
            set.add(num);
        }
        if(set.size()<3) return Collections.max(set);
        //if not then remove first two max
        set.remove(Collections.max(set));
        set.remove(Collections.max(set));
        return Collections.max(set);
        
    }
}