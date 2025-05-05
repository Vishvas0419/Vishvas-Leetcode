class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        Map<Character,Integer> map = new HashMap<>();
        int []freq = new int[26];
        int max = Integer.MIN_VALUE;
        int maxOcc = Integer.MIN_VALUE;
        for(int right=0;right<s.length();right++)
        {
            maxOcc = Math.max(maxOcc, ++freq[s.charAt(right)-'A']);
            while(right-left+1 - maxOcc > k){
                freq[s.charAt(left) - 'A']--;
                left ++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;

        
    }
}