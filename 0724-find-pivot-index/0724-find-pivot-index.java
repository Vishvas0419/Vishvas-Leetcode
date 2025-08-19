class Solution {
    public int pivotIndex(int[] nums) {
        int [] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        for(int i=0;i<nums.length;i++)
        {
            int leftSum = prefixSum[i] - nums[i];
            int rightSum = prefixSum[nums.length-1] - prefixSum[i];
            if(leftSum == rightSum) return i; //pivot index 
        }
        return -1;
    }
}