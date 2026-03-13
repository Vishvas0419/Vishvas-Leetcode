class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum += nums[i];
        }
        if(sum%2!=0) return false; //odd,cant make equal subset sum
        else if(sum%2 == 0) //even, can make equal subset
        {
            return isSubsetSum(nums,sum/2);
        }
        return true;
    }
    private static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean [][]dp = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(j==0) dp[i][j] = true;
                else if(i==0) dp[i][j] = false;
                else if(arr[i-1]<=j)
                {
                    boolean pick = dp[i-1][j-arr[i-1]];
                    boolean notPick = dp[i-1][j];
                    dp[i][j] = pick || notPick;
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];  
    }
}