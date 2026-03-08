class Solution {
    public int rob(int[] nums) {
        //tabulation code in space = O(N)
        int n = nums.length;
        int[]dp = new int[n];
        if(n==1) return nums[0];
        //store base cases in dp array
        dp[0] = nums[0]; //if we have one house to rob
        dp[1] = Math.max(nums[0],nums[1]); //if we have 2 houses to rob we will take the max one
        for(int i=2;i<n;i++)
        {
            int pick = nums[i] + dp[i-2];
            int notPick = 0 + dp[i-1];
            dp[i]  = Math.max(pick,notPick);
        }
        return dp[n-1];
    }
}