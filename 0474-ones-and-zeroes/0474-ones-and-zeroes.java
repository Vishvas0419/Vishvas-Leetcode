class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //tabulation approach (bottom up approach)
        int[][][]dp = new int[strs.length+1][m+1][n+1];
        // if(index==strs.length) return 0; by default dp[strs.length][m][n]
        for(int i=strs.length-1;i>=0;i--)
        {
            int zeroCount = countZeroes(strs[i]);
            int oneCount = countOnes(strs[i]);
            for(int j=0;j<=m;j++)
            {
                for(int k=0;k<=n;k++)
                {
                    int notPick = dp[i+1][j][k];
                    int pick = 0;
                    if(zeroCount<=j && oneCount<=k)
                    {
                        pick = 1 +dp[i+1][j-zeroCount][k-oneCount];
                    }
                    dp[i][j][k] = Math.max(pick,notPick);
                }
            }
        }
        return dp[0][m][n];
    }
    private static int countZeroes(String str)
    {
        int count = 0;
        for(char ch : str.toCharArray())
            if(ch=='0') count++;
        return count; 
    }
     private static int countOnes(String str)
    {
        int count = 0;
        for(char ch : str.toCharArray())
            if(ch=='1') count++;
        return count; 
    }
}