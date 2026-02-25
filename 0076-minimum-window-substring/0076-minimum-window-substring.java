class Solution {
    public String minWindow(String s, String t) {
          if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : t.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count = map.size();
        int i=0,j=0,minLen = Integer.MAX_VALUE,startIndex=-1;

        // String minSubStr = "";
        while(j<s.length())
        {
            char ch = s.charAt(j);
            if(map.containsKey(ch))
            {
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch)==0)
                {
                    count--;
                }
            }
            if(count==0)
            {
                while(count==0)
                {
                    if(j-i+1<minLen)
                    {
                        minLen = j-i+1;
                        startIndex = i;       
                    }
                    if(map.containsKey(s.charAt(i)))
                    {
                        map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
                    if(map.get(s.charAt(i))>0) count++;
                }
                i++;
                }
            }
            j++;
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(startIndex,startIndex+minLen);
    }
}