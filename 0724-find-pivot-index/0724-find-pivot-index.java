class Solution {
    public int pivotIndex(int[] nums) {
        int n= nums.length;
        //build prefixSum array

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++)
        {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        for(int i=0;i<n;i++)
        {
            int leftSum = prefixSum[i] - nums[i];
            int rightSum = prefixSum[n-1] - prefixSum[i];
            if(leftSum == rightSum) return i;
        }
        return -1;

    }
}