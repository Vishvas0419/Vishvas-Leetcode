import java.util.*;
class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> freq = new HashMap<>();
            
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                freq.put(c, freq.getOrDefault(c, 0) + 1);
                
                if (isBalanced(freq)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        
        return maxLen;
    }
    
    private boolean isBalanced(Map<Character, Integer> freq) {
        Collection<Integer> values = freq.values();
        
        Integer first = null;
        for (Integer val : values) {
            if (first == null) {
                first = val;
            } else if (!val.equals(first)) {
                return false;
            }
        }
        return true;
    }
}