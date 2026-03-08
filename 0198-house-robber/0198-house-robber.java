class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,n-1,dp);
    }
    public int solve(int[]nums,int index,int[]dp)
    {
        if(index==0) return nums[index];
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        int pick = nums[index]+solve(nums,index-2,dp);
        int notPick = 0 + solve(nums,index-1,dp);
        return dp[index] = Math.max(pick,notPick);
    }
}