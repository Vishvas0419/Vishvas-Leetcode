class Solution {
    public int rob(int[] nums) {
        //tabulation code (optimized) space = O(N)
        int n = nums.length;
        int[]dp = new int[n];
        if(n==1) return nums[0];
        //store base cases in variables instead of dp array
       int prev2 = nums[0]; //if we have one house to rob
        int prev = Math.max(nums[0],nums[1]); //if we have 2 houses to rob we will take the max one
        for(int i=2;i<n;i++)
        {
            int pick = nums[i] + prev2;
            int notPick = 0 + prev;
            int curr = Math.max(pick,notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}