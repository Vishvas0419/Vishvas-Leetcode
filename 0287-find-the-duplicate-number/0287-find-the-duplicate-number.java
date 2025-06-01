class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)
        {
            if(!set.add(num)) return num;
        }
        return -1;
        
    }
}