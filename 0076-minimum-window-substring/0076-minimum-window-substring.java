class Solution {
    public String minWindow(String s, String t) {
          if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        //store freq of 't' chars that we want to match
        for(char ch : t.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count = map.size(); //to track uniq chars
        int i=0,j=0,minLen = Integer.MAX_VALUE,startIndex=-1;
        while(j<s.length())
        {
            char ch = s.charAt(j);
            //if jth char is present in map freq[j]--;
            if(map.containsKey(ch))
            {
                map.put(ch,map.getOrDefault(ch,0)-1);
//If char count=0,we fulfill need for unique char
                if(map.get(ch)==0)
                {
                    count--;
                }
            }
        // When count=0, a potential ans (valid window) is found    
            if(count==0)
            {
                // Try to min the window by sliding 'i'
                while(count==0)
                {
                    if(j-i+1<minLen) //update minLen
                    {
                        minLen = j-i+1;
                        startIndex = i;       
                    }
                    //reverse the calculations done for 'i'th char
                    if(map.containsKey(s.charAt(i)))
                    {
                        map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
// If the count of a required character goes above 0, the window is no longer valid 
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