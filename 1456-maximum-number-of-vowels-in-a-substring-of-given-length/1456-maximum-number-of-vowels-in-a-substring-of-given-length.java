class Solution {
    public int maxVowels(String s, int k) {
        int i=0,j=0,count = 0,maxCount = 0;
        while(j<s.length())
        {
            char ch = s.charAt(j);
            if(isVowel(ch)) count++; //calculations
            if(j-i+1==k) //if we hit window size take out a ans from the calculation
            {
                maxCount = Math.max(maxCount,count);
                if(isVowel(s.charAt(i))) count--;
                i++; //slide the window
            }
            j++; //else if we didnt hit the win size yet
        }
        return maxCount;
    }
    static boolean isVowel(char ch)
    {
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}