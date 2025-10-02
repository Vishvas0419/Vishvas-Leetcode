class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        prefix[0] = nums[0];
        for(int i =1;i<nums.length;i++)
        {
            prefix[i] = prefix[i-1] + nums[i];
        }
        
        for(int i=0;i<n;i++)
        {
            int leftSum = prefix[i] - nums[i];
            int rightSum = prefix[n-1] - prefix[i];
            if(leftSum==rightSum) return i;
        }
        return -1;
        
    }
}