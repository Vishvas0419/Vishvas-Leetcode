class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;int totalSum=0;
        for(int i=0;i<n;i++) totalSum+=nums[i];
        // Impossible case
        if(Math.abs(target) > totalSum) return 0;
        // if odd, no valid integer partition exists
        if((target + totalSum) % 2 != 0) return 0;
        int s1 = (target + totalSum)/2;
        if(s1 < 0) s1 = -s1; 
        return perfectSum(nums,s1);
    }
    public int perfectSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        // Base case: for sum=0(j=0), ans = an empty subset means count=1 
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {  // ← start j from 0, not 1
                if (arr[i - 1] <= j) {
                    // Pick current element + don't pick
                    int pick = dp[i-1][j-arr[i-1]];
                    int notPick = dp[i-1][j];
                    dp[i][j] = (pick+notPick) % 1000000007;
                } else {
                    // Can't pick current element
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}