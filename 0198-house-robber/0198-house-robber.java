class Solution {
    private static int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return rec(nums,0,n);
    }
    static int rec(int[] nums,int i,int n)
    {
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int t =nums[i] + rec(nums,i+2,n);
        int N = rec(nums,i+1,n);
        return dp[i] = Math.max(t,N);
    }
}