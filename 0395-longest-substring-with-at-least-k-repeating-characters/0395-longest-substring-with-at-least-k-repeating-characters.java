class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        for(int maxUnique=1;maxUnique<=26;maxUnique++)
        {
            int[] freq = new int[26];
            int l = 0, r = 0,unique = 0,valid = 0;
            while(r < s.length())
            {
                // expand window
                int idx = s.charAt(r) - 'a';
                if(freq[idx] == 0) unique++;
                freq[idx]++;
                if(freq[idx] == k) valid++;
                r++;

                // shrink if too many unique chars
                while(unique > maxUnique)
                {
                    int leftIdx = s.charAt(l) - 'a';
                    if(freq[leftIdx] == k) valid--;
                    freq[leftIdx]--;
                    if(freq[leftIdx] == 0) unique--;
                    l++;
                }

                // check valid substring
                if(unique == maxUnique && unique == valid)
                    res = Math.max(res, r - l);
            }
        }

        return res;
    }
}
