class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,maxFreq = 0,maxLen = 0;
        int[]freq = new int[26];
        while(j<s.length())
        {
            freq[s.charAt(j)-'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(j)-'A']);
            //if window invalid then shrink 
            if(j-i+1-maxFreq > k)
            {
                freq[s.charAt(i)-'A']--; 
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1); //update ans
            j++;//inc the window
        }
        return maxLen;
    }
}