class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length()<3) return 0;
        int count = 0;
        for(int i=0;i<=s.length()-3;i++)
        {
            Set<Character> set = new HashSet<>();
            String sub = s.substring(i,i+3);
            for(char ch : sub.toCharArray())
            {   
                set.add(ch);
            }
            if(set.size()==3) count++; //all chars are different
        }     
        return count;   
    }
}