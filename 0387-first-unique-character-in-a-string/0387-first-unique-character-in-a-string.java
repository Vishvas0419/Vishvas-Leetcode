class Solution {
    public int firstUniqChar(String s) {
        // TreeSet<Integer> set = new TreeSet<>();
        // for(int i=0;i<s.length();i++)
        // {
        //     char ch  = s.charAt(i);
        //     set.add(ch);
        //     if(!set.contains(ch))
        //     {
        //         return i;
        //     }
        // }
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s.length();i++)
        {
            if(map.get(s.charAt(i))==1) return i;
        }
        return -1;


    }
}