class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer>mpp = new HashMap<>();
        int freq;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1); 
        }
        int frequency = mpp.get(s.charAt(0));
        for(int count : mpp.values())
        {
            if(frequency!=count) return false;
        }
        return true;
        

    }
}