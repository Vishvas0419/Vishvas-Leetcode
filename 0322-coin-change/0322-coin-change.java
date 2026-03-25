class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][]dp = new int[n+1][amount+1];
        int INF = (int)1e9;
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                //base cases
                if(j==0) dp[i][j]=0; //if amt=0 then,min no of coins reqd is 0
                else if(i==0) dp[i][j]=INF;//if coins[] is empty then we cant make that amount so INF;
                else if(coins[i-1]<=j)
                {
                    int pick = 1+dp[i][j-coins[i-1]];
                    int notPick = dp[i-1][j];
                    dp[i][j] = Math.min(pick,notPick);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount]==INF ? -1 : dp[n][amount];
    }
}