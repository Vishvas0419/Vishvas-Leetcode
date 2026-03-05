class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    static int[][]dp;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        //store index of all stones positin in map to check if the new nextStone exist or not in stones array
        for(int i=0;i<stones.length;i++) map.put(stones[i],i);
        dp = new int[n][n+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return (solve(stones,0,0)==1) ? true : false;
    }
    private int solve(int[]stones,int index,int lastJump)
    {
        if(index==stones.length-1) return 1;
        if(dp[index][lastJump]!=-1)
        {
            return dp[index][lastJump];
        }
        for(int nextJump = lastJump-1;nextJump<=lastJump+1;nextJump++)
        {
            if(nextJump>0)
            {
                int nextStone = stones[index] + nextJump;
                if(map.containsKey(nextStone))
                {
                    int nextStoneIndex = map.get(nextStone);
                    if(solve(stones,nextStoneIndex,nextJump)==1)
                    {
                        return dp[index][lastJump] = 1;
                    }
                }
            }
        }
        return dp[index][lastJump] = 0;
    }
}