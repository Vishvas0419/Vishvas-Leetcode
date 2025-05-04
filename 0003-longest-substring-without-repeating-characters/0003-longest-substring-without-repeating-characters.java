class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Sliding Window + HashSet
        int left=0,right=0,maxLen=0;
        HashSet<Character> set = new HashSet<>();
        while(right<s.length())
        {
            char ch = s.charAt(right);
            if(!set.contains(ch))
            {
                set.add(ch);
                maxLen=Math.max(maxLen,right-left+1);
                right++;
            }
            else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
}