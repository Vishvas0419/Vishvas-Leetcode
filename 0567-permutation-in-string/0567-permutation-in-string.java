class Solution {
    public boolean checkInclusion(String s1, String s2) {
        for(int i = 0;i<=s2.length()-s1.length();i++) {
            String sub = s2.substring(i,i +s1.length());
            if(isAnagram(sub, s1)) return true;
        }
        return false;
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char []a = s.toCharArray();
        char []b = t.toCharArray();
        Arrays.sort(a);Arrays.sort(b);
        return Arrays.equals(a,b);
    }
}