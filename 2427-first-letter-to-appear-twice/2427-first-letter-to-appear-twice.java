class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character>st = new HashSet<>();
        for(int i = 0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(st.contains(ch))
            {
                return ch;
            }
            else st.add(ch);
        }   
        return '\0';     
    }
}