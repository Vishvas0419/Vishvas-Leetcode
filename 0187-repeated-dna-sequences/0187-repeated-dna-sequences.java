class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for(int i=0;i<=s.length()-10;i++)
        {
            String subStr = s.substring(i,i+10);
            if(seen.contains(subStr)) ans.add(subStr);
            else seen.add(subStr);
        }
        return new ArrayList<>(ans);
    }
}