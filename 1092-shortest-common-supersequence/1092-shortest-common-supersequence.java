class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // Step 1: Build LCS DP table
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) 
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } 
                else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        // Step 2: Backtrack to build SCS
        int i = m, j = n;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                // common char → take once
                sb.append(s1.charAt(i - 1));
                i--; j--;
            } 
            //if i-1 th char is greater take it 
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(s1.charAt(i - 1));
                i--;
            } 
            //if j-1 char is greater take it
            else {
                sb.append(s2.charAt(j - 1));
                j--;
            }
        }
        //if any of the i or j is not 0 then add them to string
        while (i > 0) {
            sb.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(s2.charAt(j - 1));
            j--;
        }
        // reverse final answer beacuse we backtrack
        return sb.reverse().toString();
    }
}