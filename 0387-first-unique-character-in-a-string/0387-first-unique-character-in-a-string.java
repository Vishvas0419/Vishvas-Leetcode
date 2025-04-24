class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer>mpp = new HashMap<>();  
        // count frequency of each character
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }
        //check key(char) whose value(count) is 1
        for(int i=0;i<s.length();i++)
        {
            if(mpp.get(s.charAt(i)) == 1) 
            {
                return i;
            }
        }
        return -1;
    }
}