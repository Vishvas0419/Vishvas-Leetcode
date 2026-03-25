class Solution {
    static int[][]dp = new int[1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(); int n = text2.length();
        for(int i=0;i<1001;i++) Arrays.fill(dp[i],-1);
        return solve(text1,text2,m,n);
    }
    private static int solve(String x,String y,int m,int n)
    {
        if(m==0||n==0) return 0;
        if(dp[m][n]!=-1) return dp[m][n]; 
        if(x.charAt(m-1)==y.charAt(n-1))
        {
            return dp[m][n] = 1+solve(x,y,m-1,n-1);
        }
        else{
            int skipLastCharOfY = solve(x,y,m,n-1);
            int skipLastCharOfX = solve(x,y,m-1,n);
            return dp[m][n] = Math.max(skipLastCharOfY,skipLastCharOfX);
        }
    }
}