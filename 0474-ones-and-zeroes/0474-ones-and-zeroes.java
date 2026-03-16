class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][]dp = new int[strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++)
        {
            for(int j=0;j<=m;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,m,n,strs,dp);
    }
    //recursive approach
    private static int solve(int index,int m,int n,String[]strs,int[][][]dp)
    {
        if(index==strs.length) return 0;
        if(dp[index][m][n]!=-1) return dp[index][m][n];
        int zeroCount = countZeroes(strs[index]);
        int oneCount = countOnes(strs[index]);
        int notPick = solve(index+1,m,n,strs,dp);
        int pick = 0;
        if(zeroCount<=m && oneCount<=n)
        {
            pick = 1 + solve(index+1,m-zeroCount,n-oneCount,strs,dp);
        }

        return dp[index][m][n] = Math.max(pick,notPick);
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