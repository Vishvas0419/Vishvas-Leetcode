class Solution {
    public int maxScore(String s) {
        int maxScore = 0;
        int len = s.length();
        for(int i=1;i<len;i++)
        {
            String leftStr = s.substring(0,i);
            String rightStr = s.substring(i);
            int zeroesInLeft = 0;
            for(char ch : leftStr.toCharArray())
            {
                if(ch == '0') zeroesInLeft++;
            }
            int onesInRight = 0;
            for(char ch : rightStr.toCharArray())
            {
                if(ch == '1') onesInRight++;
            }
            int currentScore=zeroesInLeft + onesInRight;
            if(currentScore > maxScore) maxScore = currentScore; 
        }
        return maxScore;
    }
}