class Solution {
    public int numberOfSubstrings(String s) {
        int count =0 ;
        int []hash = new int[3];
         Arrays.fill(hash, -1);
        for(int i=0;i<s.length();i++)
        {
            hash[s.charAt(i)-'a'] = i;
            if(hash[0]!=-1 && hash[1]!=-1 && hash[2]!=-1)
            {
                int minIndex = Math.min(hash[0], Math.min(hash[1], hash[2]));
                    count += (minIndex + 1);
            }
        }
        return count;
    }
}